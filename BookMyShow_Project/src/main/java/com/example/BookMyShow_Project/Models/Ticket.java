package com.example.BookMyShow_Project.Models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="ticketDetails")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;
    private String movieName;
    private Integer totalPrice;
    private String bookedSeats;
    private LocalDate showDate;
    private LocalTime showTime;
    private String theaterAddress;

    @ManyToOne
    @JoinColumn
    private Show show;

    @ManyToOne
    @JoinColumn
    private User user;

}
