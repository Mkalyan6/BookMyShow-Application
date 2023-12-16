package com.example.BookMyShow_Project.Service;


import com.example.BookMyShow_Project.Models.Movie;
import com.example.BookMyShow_Project.Repository.MovieRepository;
import com.example.BookMyShow_Project.RequestDTOs.AddMovieRequest;
import com.example.BookMyShow_Project.Transformers.MovieTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public String addMovie(AddMovieRequest addMovieRequest)throws Exception{
        Movie movie=MovieTransformers.ConvertRequestToMovie(addMovieRequest);
        movieRepository.save(movie);

        return "Movie has been successfully added and the movieId is:"+movie.getMovieId();

    }
}
