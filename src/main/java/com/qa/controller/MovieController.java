package com.qa.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dto.MovieDTO;
import com.qa.domain.ShowTime;
import com.qa.domain.Movie;
import com.qa.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private MovieService service;

    @Autowired
    public MovieController(MovieService service) {
        super();
        this.service = service;
    }

    @PostMapping("/createMovie")
    public ResponseEntity<MovieDTO> createMovie(@RequestBody Movie movie) {
        return new ResponseEntity<MovieDTO>(this.service.createMovie(movie), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteMovie/{id}")
    public ResponseEntity<MovieDTO> deleteMovie(@PathVariable Long id) {
        return this.service.deleteMovie(id) ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MovieDTO> getMovie(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.findMovieByID(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        return ResponseEntity.ok(this.service.readMovies());
    }

    @PutMapping("/updateMovie")
    public ResponseEntity<MovieDTO> updateMovie(@PathParam("id") Long id, @RequestBody Movie movie) {
        return new ResponseEntity<MovieDTO>(this.service.updateMovie(movie, id), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<MovieDTO> addShowTimeToMovie(@PathVariable Long id, @RequestBody ShowTime showTime) {
        return new ResponseEntity<MovieDTO>(this.service.addShowTimeToMovie(id, showTime), HttpStatus.ACCEPTED);
    }

}