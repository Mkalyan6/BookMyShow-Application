package com.example.BookMyShow_Project.Controller;

import com.example.BookMyShow_Project.Models.User;
import com.example.BookMyShow_Project.RequestDTOs.AddUserRequest;
import com.example.BookMyShow_Project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/save")

    public ResponseEntity addUser(@RequestBody AddUserRequest userDTO){
         userService.addUser(userDTO);
         return new ResponseEntity<>("User Has been successfully added", HttpStatus.OK);
    }
}
