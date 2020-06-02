package com.qa.test.service;

import com.qa.domain.Movie;
import com.qa.dto.MovieDTO;
import com.qa.repo.MovieRepo;
import com.qa.service.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieServiceIntegrationTest {

    @Autowired
    private MovieService service;

    @Autowired
    private MovieRepo repo;

    private Movie testMovie;

    private Movie testMovieWithID;

    @Autowired
    private ModelMapper mapper;

    private MovieDTO mapToDTO(Movie movie) {
        return this.mapper.map(movie, MovieDTO.class);
    }

    @Before
    public void init() {
        this.testMovie = new Movie(24928L,"showing", "R");

        this.repo.deleteAll();

        this.testMovieWithID = this.repo.save(this.testMovie);
    }

    @Test
    public void testCreateMovie() {
        assertEquals(this.mapToDTO(this.testMovieWithID), this.service.createMovie(testMovie));
    }

    @Test
    public void testDeleteMovie() {
        assertThat(this.service.deleteMovie(this.testMovieWithID.getId())).isFalse();
    }

    @Test
    public void testFindMovieByID() {
        assertThat(this.service.findMovieByID(this.testMovieWithID.getId())).isEqualTo(this.mapToDTO(this.testMovieWithID));
    }

    @Test
    public void testReadMovies() {
        assertThat(this.service.readMovies()).isEqualTo(Stream.of(this.mapToDTO(testMovieWithID)).collect(Collectors.toList()));
    }

    @Test
    public void testUpdateMovie() {
        Movie newMovie = new Movie(154085L,"showing","PG");
        Movie updatedMovie = new Movie(newMovie.getApiID(),newMovie.getStatus(), newMovie.getRating());
        updatedMovie.setId(this.testMovieWithID.getId());

        assertThat(this.service.updateMovie(newMovie, this.testMovieWithID.getId())).isEqualTo(this.mapToDTO(updatedMovie));
    }

}