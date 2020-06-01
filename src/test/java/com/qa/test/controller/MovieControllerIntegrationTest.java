package com.qa.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.domain.Movie;
import com.qa.repo.MovieRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class MovieControllerIntegrationTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private MovieRepo repo;

    private ObjectMapper mapper = new ObjectMapper();

    private long id;

    private Movie testMovie;

    private Movie testMovieWithID;

    @Before
    public void init() {
        this.repo.deleteAll();
        this.testMovie = new Movie(129341L,"featured", "PG-13");
        this.testMovieWithID = this.repo.save(this.testMovie);
        this.id = this.testMovieWithID.getId();
    }

    @Test
    public void testCreateMovie() throws Exception {
        String result = this.mock
                .perform(request(HttpMethod.POST, "/movie/createMovie").contentType(MediaType.APPLICATION_JSON)
                        .content(this.mapper.writeValueAsString(testMovie)).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();
        assertEquals(this.mapper.writeValueAsString(testMovieWithID), result);
    }

    @Test
    public void testDeleteMovie() throws Exception {
        this.mock.perform(request(HttpMethod.DELETE, "/movie/deleteMovie/" + this.id)).andExpect(status().isNoContent());
    }

    @Test
    public void testGetMovie() throws Exception {
        String content = this.mock
                .perform(request(HttpMethod.GET, "/movie/get/" + this.id).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals(this.mapper.writeValueAsString(this.testMovie), content);
    }

    @Test
    public void testGetAllMovies() throws Exception {
        List<Movie> movieList = new ArrayList<>();
        movieList.add(this.testMovieWithID);

        String content = this.mock.perform(request(HttpMethod.GET, "/movie/getAll").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals(this.mapper.writeValueAsString(movieList), content);
    }

    @Test
    public void testUpdateMovie() throws Exception {
        Movie newMovie = new Movie(129341L,"showing", "R");
        Movie updatedMovie = new Movie(newMovie.getApiID(), newMovie.getStatus(), newMovie.getRating());
        updatedMovie.setId(this.id);

        String result = this.mock
                .perform(request(HttpMethod.PUT, "/movie/updateMovie/?id=" + this.id).accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(newMovie)))
                .andExpect(status().isAccepted()).andReturn().getResponse().getContentAsString();

        assertEquals(this.mapper.writeValueAsString(updatedMovie), result);
    }

}