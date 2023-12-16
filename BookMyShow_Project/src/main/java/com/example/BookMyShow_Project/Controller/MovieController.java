package com.example.BookMyShow_Project.Controller;

import com.example.BookMyShow_Project.RequestDTOs.AddMovieRequest;
import com.example.BookMyShow_Project.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/addMovie")
    public ResponseEntity addMovie(@RequestBody AddMovieRequest addMovieRequest){
        // If user enters movie name mutlple times, throws exception by jdbc
        // Better maintain try and catch block to catch those
        try {
            String message = movieService.addMovie(addMovieRequest);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
