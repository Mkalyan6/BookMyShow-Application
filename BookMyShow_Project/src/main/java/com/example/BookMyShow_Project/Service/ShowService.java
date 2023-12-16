package com.example.BookMyShow_Project.Service;

import com.example.BookMyShow_Project.Enums.SeatType;
import com.example.BookMyShow_Project.Models.*;
import com.example.BookMyShow_Project.Repository.MovieRepository;
import com.example.BookMyShow_Project.Repository.ShowRepository;
import com.example.BookMyShow_Project.Repository.TheaterRepository;
import com.example.BookMyShow_Project.RequestDTOs.AddShowRequest;
import com.example.BookMyShow_Project.RequestDTOs.AddShowSeatsRequest;
import com.example.BookMyShow_Project.Transformers.ShowTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.support.RepositoryFragment;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;
    public String addShow(AddShowRequest addShowRequest) {
        // Converr this showrequest to show object using data transformers
        Show show= ShowTransformers.convertRequestToShow(addShowRequest);

        String movieName= addShowRequest.getMovieName();
        Integer theaterId=addShowRequest.getTheaterId();

        // Add the foreign key attributes
        Optional<Movie> movieOptional=movieRepository.findMovieBymovieName(movieName);

        Movie movie=movieOptional.get();

        Optional<Theater>optionalTheater=theaterRepository.findById(theaterId);

        Theater theater=optionalTheater.get();

        show.setMovie(movie);
        show.setTheater(theater);

        //Bidirectional Mapping
        theater.getShowList().add(show);
        movie.getShowList().add(show);

        // Now save the child  as it saves both the parents due to cascading effect
        showRepository.save(show);

        return "The show has been successfully added to DB: "+show.getShowId();


    }

    public String createShowSeats(AddShowSeatsRequest addShowSeatsRequest) {
        // first find the show details by searching in table
        Integer showId=addShowSeatsRequest.getShowId();
        double classicSeatCost=addShowSeatsRequest.getClassicSeatCost();
        double premiumSeatCost=addShowSeatsRequest.getPremiumSeatCost();

        if(showId!=null) {
            Optional<Show> optionalShow = showRepository.findById(showId);
            Show show = optionalShow.get();
        // now find the theater and take the seats list from the theater
        // and create a showseats model with the list of seats with availability details;
        Theater theater =show.getTheater();
        List<TheaterSeat> TheaterSeatList=theater.getTheaterSeatsList();


        // Create a showseatList with some details of individual seats;
        // Now traverse through all the seats for the seatno, and add it to show seats entity
        for(TheaterSeat theaterSeat:TheaterSeatList){
            ShowSeatInfo showSeatInfo=ShowSeatInfo.builder()
                    .seatNo(theaterSeat.getSeatNo())
                    .seatType(theaterSeat.getSeatType())
                    .isAvailable(true)
                    .isFoodAttached(false)
                    .build();
             if(showSeatInfo.getSeatType()== SeatType.CLASSIC){
                 showSeatInfo.setCost(classicSeatCost);
             }else{
                 showSeatInfo.setCost(premiumSeatCost);
             }



            show.getShowSeatList().add(showSeatInfo);
             showSeatInfo.setShow(show);
            
        }
          showRepository.save(show);
        return "Seats for the show has been perfectly set";
        }else {
            return "Enter the correct ShowId";
        }

    }
}
