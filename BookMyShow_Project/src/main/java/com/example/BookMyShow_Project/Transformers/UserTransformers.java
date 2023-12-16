package com.example.BookMyShow_Project.Transformers;

import com.example.BookMyShow_Project.Models.User;
import com.example.BookMyShow_Project.RequestDTOs.AddUserRequest;

public class UserTransformers {


   public static User ConvertUserDTO_toUserObject(AddUserRequest userDTO){
       User user=User.builder()
               .age(userDTO.getAge())
               .name(userDTO.getName())
               .mobileNo(userDTO.getMobileNo())
               .mailId(userDTO.getMailId())
               .build();
          return user;
    }
}
