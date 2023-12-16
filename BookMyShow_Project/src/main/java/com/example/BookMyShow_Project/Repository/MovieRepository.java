package com.example.BookMyShow_Project.Repository;

import com.example.BookMyShow_Project.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    Optional<Movie> findMovieBymovieName(String movieName);
}
