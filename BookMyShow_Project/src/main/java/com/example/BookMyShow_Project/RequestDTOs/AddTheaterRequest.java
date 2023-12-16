package com.example.BookMyShow_Project.RequestDTOs;

import com.example.BookMyShow_Project.Enums.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AddTheaterRequest {
//    private Integer theaterId;
    private String name;
    private  String address;
    private Location location;

    private int noOfPremiumSeats;
    private int noOfClassicSeats;
    private int noOfSeatsPerRow;

}
