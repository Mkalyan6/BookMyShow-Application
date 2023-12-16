package com.example.BookMyShow_Project.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Show_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showId;

    private LocalTime showTime;
    private LocalDate showDate;

    @ManyToOne
    @JoinColumn
    private Theater theater;

    @ManyToOne
    @JoinColumn
    private Movie movie;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<ShowSeatInfo> ShowSeatList=new ArrayList<>();

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<Ticket>ticketList=new ArrayList<>();

}
