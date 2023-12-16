package com.example.BookMyShow_Project.Service;

import com.example.BookMyShow_Project.Models.*;
import com.example.BookMyShow_Project.Repository.*;
import com.example.BookMyShow_Project.RequestDTOs.BookTicketRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JavaMailSender javaMailSender;


    public String addTicket(BookTicketRequest bookTicketRequest) {
        // Create a ticket object from the attributes of bookTicketRequest
        Show show=FindRightShow(bookTicketRequest);
//        List<String>SeatList=new ArrayList<>();
         List<String> SeatList=bookTicketRequest.getSeatNos();


        int totalPrice=0;

        // find the seatsSelected for particular show and calculate the price
        for(ShowSeatInfo showSeatInfo:show.getShowSeatList()){
            if(SeatList!=null&&SeatList.contains(showSeatInfo.getSeatNo())){
                showSeatInfo.setAvailable(false);
                totalPrice+=showSeatInfo.getCost();
            }
        }


//        Create ticket entity with the furnished details
        Ticket ticket= Ticket.builder()
                .movieName(show.getMovie().getMovieName())
                .showDate(show.getShowDate())
                .showTime(show.getShowTime())
                .theaterAddress(show.getTheater().getAddress())
                .user(userRepository.findById(bookTicketRequest.getUserId()).get())
                .show(show)
                .totalPrice(totalPrice)
//                .bookedSeats(SeatList.toString())
                .build();

             if(SeatList!=null){
                 ticket.setBookedSeats(SeatList.toString());
        }

              // Now set the foreign key attributes
            show.getTicketList().add(ticket);
            User user=userRepository.findById(bookTicketRequest.getUserId()).get();
            user.getTicketList().add(ticket);

            //Now save the child entity to db
             ticketRepository.save(ticket);

             // Send the ticket booking status to the user from mail using mail integration
        SimpleMailMessage message=new SimpleMailMessage();
         String body=" Hi "+user.getName()+".You have successfully booked tickets for the following seats: "+SeatList.toString()+" And the total price is:"+totalPrice+"Happy watching :Movie: "+bookTicketRequest.getMovieName();
         message.setFrom("kalyanmanukondamail@gmail.com");
         message.setTo(user.getMailId());
         message.setSubject("MOVIE TICKET CONFIRMATION");
         message.setText(body);
         javaMailSender.send(message);
             return "Tickets have booked for the seats mentioned and total price for the tickets is:"+totalPrice;

    }


    private Show FindRightShow(BookTicketRequest bookTicketRequest) {
        LocalDate showDate=bookTicketRequest.getShowDate();
        LocalTime showTime=bookTicketRequest.getShowTime();

        Optional<Movie> optionalMovie= movieRepository.findMovieBymovieName(bookTicketRequest.getMovieName());
        Movie movie=optionalMovie.get();

        Optional<Theater> optionalTheater= theaterRepository.findById(bookTicketRequest.getTheaterId());
        Theater theater=optionalTheater.get();

        Show show=showRepository.findShowByShowDateAndShowTimeAndMovieAndTheater(showDate,showTime,movie,theater);
        return show;
    }
}
