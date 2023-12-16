package com.example.BookMyShow_Project.RequestDTOs;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AddUserRequest
{

    // In this class the user details are taken and send to user object and  gets saved into db
    private String name;
    private String mailId;
    private String mobileNo;
    private int age;
}
