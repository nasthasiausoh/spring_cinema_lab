package com.example.spring_cinema.services;

import com.example.spring_cinema.models.Movie;
import com.example.spring_cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

//      method for getting movies by id:
    public Optional<Movie> getMovieById(int id){
        return movieRepository.findById(id);
    }


////    Method for adding movies:
//    public void addMovies(String title, String rating, int duration){
//        Movie movie = new Movie(title, rating, duration);
//        movieRepository.save(movie);
//    }

//    BETTER METHOD FOR ADDING MOVIES:
    public Movie addNewMovies(Movie movie){
        movieRepository.save(movie);
        return movie;
    }

//    Method for updating movies:
    public Movie updateMovie(Movie movie){
        movieRepository.save(movie);
        return movie;
    }



//    method for deleting movies:
    public void removeMoviesByInt(int id){
        movieRepository.deleteById(id);
    }





//    Getters and setters


    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }


    public List<Movie> filterMoviesByDuration(Integer maxDuration) {
        List<Movie> allMovies = movieRepository.findAll();
        List<Movie> filteredMovies = new ArrayList<>();

        for (Movie movie : allMovies) {
            if (movie.getDuration() <= maxDuration){
                filteredMovies.add(movie);
            }
        }

        return filteredMovies;
    }
}
