package com.example.BookMyShow_Project.RequestDTOs;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddShowSeatsRequest {
    private Integer showId;
    private double classicSeatCost;
    private double premiumSeatCost;

}
