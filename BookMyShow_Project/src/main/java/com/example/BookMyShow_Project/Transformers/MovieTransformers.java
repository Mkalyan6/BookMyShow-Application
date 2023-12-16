package com.example.BookMyShow_Project.Transformers;

import com.example.BookMyShow_Project.Models.Movie;
import com.example.BookMyShow_Project.RequestDTOs.AddMovieRequest;

public class MovieTransformers {

    public static Movie ConvertRequestToMovie(AddMovieRequest addMovieRequest){
        Movie movie=Movie.builder()
                .movieGenre(addMovieRequest.getMovieGenre())
                .movieName(addMovieRequest.getMovieName())
                .releaseDate(addMovieRequest.getReleaseDate())
                .rating(addMovieRequest.getRating())
                .build();
            return movie;
    }
}
