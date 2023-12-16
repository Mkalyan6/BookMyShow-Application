package com.example.BookMyShow_Project.Models;

import com.example.BookMyShow_Project.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Theater_Seats")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TheaterSeat {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer theaterseatId;
    private String seatNo;
    @Enumerated(value=EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn
    private Theater theater;
}
