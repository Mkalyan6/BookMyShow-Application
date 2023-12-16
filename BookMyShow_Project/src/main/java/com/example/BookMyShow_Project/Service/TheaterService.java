package com.example.BookMyShow_Project.Service;

import com.example.BookMyShow_Project.Enums.SeatType;
import com.example.BookMyShow_Project.Models.Theater;
import com.example.BookMyShow_Project.Models.TheaterSeat;
import com.example.BookMyShow_Project.Repository.TheaterRepository;
import com.example.BookMyShow_Project.Repository.TheaterSeatRepository;
import com.example.BookMyShow_Project.RequestDTOs.AddTheaterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {
    @Autowired
    TheaterRepository theaterRepository;

    public ResponseEntity addTheater(AddTheaterRequest addTheaterRequest) {
        // first creata a theater entity
        Theater theater= Theater.builder()
                .name(addTheaterRequest.getName())
                .address(addTheaterRequest.getAddress())
                .location(addTheaterRequest.getLocation())
                .build();
        // Add Createseats to the theater entity
        CreateSeatsForTheater(theater,addTheaterRequest);
        return new ResponseEntity<>("Theater has been added to database",HttpStatus.OK);
    }
    public void CreateSeatsForTheater(Theater theater,AddTheaterRequest addTheaterRequest){
        int noOfPremiumSeats= addTheaterRequest.getNoOfPremiumSeats();
        int nofOfClassicSeats= addTheaterRequest.getNoOfClassicSeats();
        int SeatsPerRow= addTheaterRequest.getNoOfSeatsPerRow();

        List<TheaterSeat> theaterSeatList=new ArrayList<>();

        // Create classic seats with seatno
        char ch='A';
        int row=1;
        for(int i=1;i<=nofOfClassicSeats;i++){
            // design the seatNo
            String seatNo=row+""+ch;
            ch++;
            TheaterSeat theaterSeat=TheaterSeat.builder()
                    .seatNo(seatNo)
                    .theater(theater)
                    .seatType(SeatType.CLASSIC)
                    .build();
            // Add this seat to theater list of seats;
            theaterSeatList.add(theaterSeat);

            if(i%SeatsPerRow==0){
                // means that we have reached the max alloted seats per row,
                // so now have to change to next row for seat alotment
                row++;
                ch='A';
            }
        }

        // Create seats for PremiumSeats
        ch='A';
         if(nofOfClassicSeats%SeatsPerRow!=0)row++;
        for(int i=1;i<=noOfPremiumSeats;i++){
            // design the seatNo
            String seatNo=row+""+ch;
            ch++;
            TheaterSeat theaterSeat=TheaterSeat.builder()
                    .seatNo(seatNo)
                    .theater(theater)
                    .seatType(SeatType.PREMIUM)
                    .build();
            // Add this seat to theater list of seats;
            theaterSeatList.add(theaterSeat);

            if(i%SeatsPerRow==0){
                // means that we have reached the max alloted seats per row,
                // so now have to change to next row for seat alotment
                row++;
                ch='A';
            }
        }

             // For Bidirectional mapping add the list of seats to theater entity
              theater.setTheaterSeatsList(theaterSeatList);

            // save the theater entity
              theaterRepository.save(theater);


    }
}
