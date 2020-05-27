package com.qa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.dto.MovieDTO;
import com.qa.exceptions.MovieNotFoundException;
import com.qa.domain.ShowTime;
import com.qa.domain.Movie;
import com.qa.repo.ShowTimeRepo;
import com.qa.repo.MovieRepo;

@Service
public class MovieService {

    private MovieRepo repo;

    private ShowTimeRepo showTimeRepo;

    private Mapper<Movie, MovieDTO> mapper;

    @Autowired
    public MovieService(MovieRepo repo, ShowTimeRepo showTimeRepo, ModelMapper mapper) {
        this.repo = repo;
        this.showTimeRepo = showTimeRepo;
        this.mapper = (Movie movie) -> mapper.map(movie, MovieDTO.class);
    }


    public MovieDTO createMovie(Movie movie) {
        return this.mapper.mapToDTO(this.repo.save(movie));
    }

    public boolean deleteMovie(Long id) {
        if (!this.repo.existsById(id)) {
            throw new MovieNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

    public MovieDTO findMovieByID(Long id) {
        return this.mapper.mapToDTO(this.repo.findById(id).orElseThrow(() -> new MovieNotFoundException()));
    }

    public List<MovieDTO> readMovies() {
        return this.repo.findAll().stream().map(this.mapper::mapToDTO).collect(Collectors.toList());
    }

    public MovieDTO updateMovie(Movie showTime, Long id) {
        Movie toUpdate = this.repo.findById(id).orElseThrow(() -> new MovieNotFoundException());
        toUpdate.setName(showTime.getName());
        return this.mapper.mapToDTO(this.repo.save(toUpdate));
    }

    public MovieDTO addShowTimeToMovie(Long id, ShowTime showTime) {
        Movie toUpdate = this.repo.findById(id).orElseThrow(() -> new MovieNotFoundException());
        ShowTime newShowTime = this.showTimeRepo.save(showTime);
        toUpdate.getShowTimes().add(newShowTime);
        return this.mapper.mapToDTO(this.repo.saveAndFlush(toUpdate));
    }

}
