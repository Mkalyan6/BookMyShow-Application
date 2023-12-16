package com.example.BookMyShow_Project.RequestDTOs;

import com.example.BookMyShow_Project.Enums.MovieGenre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMovieRequest {
    private String movieName;
    private MovieGenre movieGenre;
    private LocalDate releaseDate;
    private double rating;
}
