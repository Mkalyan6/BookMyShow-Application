package com.example.BookMyShow_Project.Models;

import com.example.BookMyShow_Project.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ShowSeatInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatId;

    private String seatNo;
    private boolean isAvailable;
    private double cost;
    @Enumerated(value=EnumType.STRING)
    private SeatType seatType;
    private boolean isFoodAttached;
    @ManyToOne
    @JoinColumn
    private Show show;
}
