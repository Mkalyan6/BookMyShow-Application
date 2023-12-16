package com.example.BookMyShow_Project.Models;

import com.example.BookMyShow_Project.Enums.Location;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Theater")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Theater {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer theaterId;

    private String name;
    private String address;
    @Enumerated(value=EnumType.STRING)
    private Location location;
    @OneToMany(mappedBy = "theater",cascade=CascadeType.ALL)
    private List<TheaterSeat> TheaterSeatsList=new ArrayList<>();

    @OneToMany(mappedBy="theater",cascade = CascadeType.ALL)
    private List<Show>showList=new ArrayList<>();

}
