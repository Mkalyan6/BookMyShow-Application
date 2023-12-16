package com.example.BookMyShow_Project.Service;

import com.example.BookMyShow_Project.Models.User;
import com.example.BookMyShow_Project.Repository.UserRepository;
import com.example.BookMyShow_Project.RequestDTOs.AddUserRequest;
import com.example.BookMyShow_Project.Transformers.UserTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void addUser(AddUserRequest userDTO) {
        // Now we got the customesized dto user , and add these data to original entity class
        // And add it to db

       User user= UserTransformers.ConvertUserDTO_toUserObject(userDTO);

        userRepository.save(user);

    }
}
