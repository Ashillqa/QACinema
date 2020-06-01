package com.qa.test.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.dto.MovieDTO;
import com.qa.domain.Movie;
import com.qa.controller.MovieController;
import com.qa.service.MovieService;

@RunWith(MockitoJUnitRunner.class)
public class MovieControllerUnitTest {

    @InjectMocks
    private MovieController controller;

    @Mock
    private MovieService service;

    private List<Movie> movieList;

    private Movie testMovie;

    private Movie testMovieWithID;

    private MovieDTO movieDTO;

    final long id = 1L;

    private ModelMapper mapper = new ModelMapper();


    private MovieDTO mapToDTO(Movie movie) {
        return this.mapper.map(movie, MovieDTO.class);
    }


    @Before
    public void init() {
        this.movieList = new ArrayList<>();
        this.testMovie = new Movie(21344534L,"showing", "PG-13");
        this.movieList.add(testMovie);
        this.testMovieWithID = new Movie(testMovie.getApiID(), testMovie.getStatus(), testMovie.getRating());
        this.testMovieWithID.setId(id);
        this.movieDTO = this.mapToDTO(testMovieWithID);
    }

    @Test
    public void createMovieTest() {
        when(this.service.createMovie(testMovie)).thenReturn(this.movieDTO);

        assertEquals(new ResponseEntity<MovieDTO>(this.movieDTO, HttpStatus.CREATED), this.controller.createMovie(testMovie));

        verify(this.service, times(1)).createMovie(this.testMovie);
    }

    @Test
    public void deleteMovieTest() {
        this.controller.deleteMovie(id);

        verify(this.service, times(1)).deleteMovie(id);
    }

    @Test
    public void findMovieByIDTest() {
        when(this.service.findMovieByID(this.id)).thenReturn(this.movieDTO);

        assertEquals(new ResponseEntity<MovieDTO>(this.movieDTO, HttpStatus.OK), this.controller.getMovie(this.id));

        verify(this.service, times(1)).findMovieByID(this.id);
    }

    @Test
    public void getAllMoviesTest() {

        when(service.readMovies()).thenReturn(this.movieList.stream().map(this::mapToDTO).collect(Collectors.toList()));

        assertFalse("Controller has found no movies", this.controller.getAllMovies().getBody().isEmpty());

        verify(service, times(1)).readMovies();
    }

    @Test
    public void updateMoviesTest() {
        // given
        Movie newMovie = new Movie(1192384L,"featured", "R");
        Movie updatedMovie = new Movie(newMovie.getApiID(), newMovie.getStatus(),newMovie.getRating());
        updatedMovie.setId(this.id);

        when(this.service.updateMovie(newMovie, this.id)).thenReturn(this.mapToDTO(updatedMovie));

        assertEquals(new ResponseEntity<MovieDTO>(this.mapToDTO(updatedMovie), HttpStatus.ACCEPTED), this.controller.updateMovie(this.id, newMovie));

        verify(this.service, times(1)).updateMovie(newMovie, this.id);
    }

}