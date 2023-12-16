package com.example.BookMyShow_Project.Models;

import com.example.BookMyShow_Project.Enums.MovieGenre;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Movie")
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer MovieId;

    @Column(unique = true)
    private String movieName;

    @Enumerated(value=EnumType.STRING)
    private MovieGenre movieGenre;

    private double rating;
    private LocalDate releaseDate;

    @OneToMany(mappedBy="movie",cascade = CascadeType.ALL)
    private List<Show> showList=new ArrayList<>();
}
