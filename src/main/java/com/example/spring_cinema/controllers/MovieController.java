package com.example.spring_cinema.controllers;

import com.example.spring_cinema.models.Movie;
import com.example.spring_cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;


    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id){
        Optional<Movie> movie = movieService.getMovieById(id);
        if (movie.isPresent()) {
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Movie> addNewMovie(@RequestParam String title, @RequestParam String rating, @RequestParam int duration){
        movieService.addMovies(title, rating, duration);
        Movie movie = new Movie(title, rating , duration);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

// ?title=Creed&rating=15&duration=118

//    @PatchMapping
//    public ResponseEntity<Movie> deleteNewMovie(@RequestParam String title, @RequestParam String rating, @RequestParam int duration){
//        movieService.removeMovies(title, rating, duration);
//        Movie movie = new Movie(title, rating , duration);
//        return new ResponseEntity<>(movie, HttpStatus.CREATED);
//    }

}
