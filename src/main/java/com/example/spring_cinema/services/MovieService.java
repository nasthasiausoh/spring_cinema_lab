package com.example.spring_cinema.services;

import com.example.spring_cinema.models.Movie;
import com.example.spring_cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    Movie movie;

    @Autowired
    MovieRepository movieRepository;

    // MovieService constructor
    public MovieService(){

    }


//  Method responsible for listing movies:
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

//    Method for adding movies:
    public void addMovies(String title, String rating, int duration){
        Movie movie = new Movie(title, rating, duration);
        movieRepository.save(movie);
    }

    public Optional<Movie> getMovieById(int id){
        return movieRepository.findById(id);
    }

//    method for add movies:
//    public void removeMoviesByInt(int id){
//        movieRepository.deleteById(id);
//    }





//    Getters and setters


    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
