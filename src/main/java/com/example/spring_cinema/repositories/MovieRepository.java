package com.example.spring_cinema.repositories;

import com.example.spring_cinema.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // don't really need this annotation because we are extending from something that already is, but it's ok to keep it
public interface MovieRepository extends JpaRepository<Movie, Integer> {   // it has be to a relative type (hence Integer and not int)

}
