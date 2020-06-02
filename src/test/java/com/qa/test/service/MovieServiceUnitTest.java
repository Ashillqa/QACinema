package com.qa.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.dto.MovieDTO;
import com.qa.domain.Movie;
import com.qa.repo.MovieRepo;
import com.qa.service.MovieService;

@RunWith(SpringRunner.class)
public class MovieServiceUnitTest {

    @InjectMocks
    private MovieService service;

    @Mock
    private MovieRepo repo;

    @Mock
    private ModelMapper mapper;

    private List<Movie> movieList;

    private Movie testMovie;

    private Movie testMovieWithID;

    private MovieDTO movieDTO;

    final long id = 1L;

    @Before
    public void init() {
        this.movieList = new ArrayList<>();
        this.movieList.add(testMovie);
        this.testMovie = new Movie(24425L,"featured", "R");
        this.testMovieWithID = new Movie(testMovie.getApiID(), testMovie.getStatus(), testMovie.getRating());
        this.testMovieWithID.setId(id);
        this.movieDTO = new ModelMapper().map(testMovieWithID, MovieDTO.class);
    }

    @Test
    public void createMovieTest() {
        when(this.repo.save(testMovie)).thenReturn(testMovieWithID);
        when(this.mapper.map(testMovieWithID, MovieDTO.class)).thenReturn(movieDTO);

        assertEquals(this.movieDTO, this.service.createMovie(testMovie));

        verify(this.repo, times(1)).save(this.testMovie);
    }

    @Test
    public void deleteMovieTest() {
        when(this.repo.existsById(id)).thenReturn(true, false);

        this.service.deleteMovie(id);

        verify(this.repo, times(1)).deleteById(id);
        verify(this.repo, times(2)).existsById(id);
    }

    @Test
    public void findMovieByIDTest() {
        when(this.repo.findById(this.id)).thenReturn(Optional.of(this.testMovieWithID));
        when(this.mapper.map(testMovieWithID, MovieDTO.class)).thenReturn(movieDTO);

        assertEquals(this.movieDTO, this.service.findMovieByID(this.id));

        verify(this.repo, times(1)).findById(this.id);
    }

    @Test
    public void readMoviesTest() {

        when(repo.findAll()).thenReturn(this.movieList);
        when(this.mapper.map(testMovieWithID, MovieDTO.class)).thenReturn(movieDTO);

        assertFalse("Controller has found no movies", this.service.readMovies().isEmpty());

        verify(repo, times(1)).findAll();
    }

    @Test
    public void updateMoviesTest(){
        Movie newMovie = new Movie(923482L,"upcoming", "PG");

        Movie updatedMovie = new Movie(newMovie.getApiID(),newMovie.getStatus(), newMovie.getRating());
        updatedMovie.setId(this.id);

        MovieDTO updatedDTO = new ModelMapper().map(updatedMovie, MovieDTO.class);


        when(this.repo.findById(this.id)).thenReturn(Optional.of(this.testMovieWithID));
        when(this.mapper.map(updatedMovie, MovieDTO.class)).thenReturn(updatedDTO);

        when(this.repo.save(updatedMovie)).thenReturn(updatedMovie);

        assertEquals(updatedDTO, this.service.updateMovie(newMovie, this.id));

        verify(this.repo, times(1)).findById(1L);
        verify(this.repo, times(1)).save(updatedMovie);
    }

}