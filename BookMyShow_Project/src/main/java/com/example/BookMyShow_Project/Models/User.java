package com.example.BookMyShow_Project.Models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @Column(unique = true)
    private String mailId;
    private String mobileNo;
    private int age;

    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    private List<Ticket> TicketList=new ArrayList<>();

}
