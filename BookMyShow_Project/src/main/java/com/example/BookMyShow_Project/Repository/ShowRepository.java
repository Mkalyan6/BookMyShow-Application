package com.example.BookMyShow_Project.Repository;

import com.example.BookMyShow_Project.Models.Movie;
import com.example.BookMyShow_Project.Models.Show;
import com.example.BookMyShow_Project.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface ShowRepository extends JpaRepository<Show,Integer> {
    Show findShowByShowDateAndShowTimeAndMovieAndTheater(LocalDate showDate, LocalTime showTime, Movie movie, Theater theater);

}
