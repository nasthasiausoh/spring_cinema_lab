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

    // (GET): INDEX
//    @GetMapping
//    public ResponseEntity<List<Movie>> getAllMovies() {
//        List<Movie> movies = movieService.getAllMovies();
//        return new ResponseEntity<>(movies, HttpStatus.OK);
//    }
//

    // (GET): SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
        Optional<Movie> movie = movieService.getMovieById(id);
        if (movie.isPresent()) {
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


//    POST:
//    @PostMapping
//    public ResponseEntity<Movie> addNewMovie(@RequestParam String title, @RequestParam String rating, @RequestParam int duration){
//        movieService.addMovies(title, rating, duration);
//        Movie movie = new Movie(title, rating , duration);
//        return new ResponseEntity<>(movie, HttpStatus.CREATED);
//        // this is not correct i don't think. we shouldn't be submitted data through the url.
//        // so we shouldn't have @requestparam here. so we shouldn't be able to do localhost:8080/movies?title=Creed&rating=15&duration=118.
//        // instead we should be submitting the data through the @RequestBody.
//    }

    // ?title=Creed&rating=15&duration=118
//    BETTER POST REQUEST:
    @PostMapping
    public ResponseEntity<Movie> addNewMovie(@RequestBody Movie movie) {
        movieService.addNewMovies(movie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }


//    EXTENSION:

//Add functionality to update a movie in the database
    @PutMapping(value = "/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable int id, @RequestBody Movie movie){
        movie.setId(id);
        movieService.updateMovie(movie);
        return new ResponseEntity(movie, HttpStatus.OK);
    }


//Add functionality to delete a movie from the database

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Movie> deleteNewMovie(@PathVariable int id) {
        movieService.removeMoviesByInt(id);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }




//    Use a @RequestParam to add a maxDuration parameter to the GET /movies request.
//    Use it to return only the movies with a duration less than the value.

    @GetMapping
    public ResponseEntity<List<Movie>>  getAllMoviesFilter(@RequestParam(required = false) Integer maxDuration) {
        List<Movie> movies;
        if (maxDuration == null) {
            movies = movieService.getAllMovies();
        } else {
            movies = movieService.filterMoviesByDuration(maxDuration);
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }





//
}
// the controller is the place where we have the ResponseEntity<>
