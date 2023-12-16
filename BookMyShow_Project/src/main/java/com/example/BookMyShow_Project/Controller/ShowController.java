package com.example.BookMyShow_Project.Controller;

import com.example.BookMyShow_Project.RequestDTOs.AddShowRequest;
import com.example.BookMyShow_Project.RequestDTOs.AddShowSeatsRequest;
import com.example.BookMyShow_Project.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Show")
public class ShowController {
    @Autowired
    ShowService showService;
    @PostMapping("/AddShow")
    public ResponseEntity addShow(@RequestBody  AddShowRequest addShowRequest){
        String message=showService.addShow(addShowRequest);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/CreateShowSeats")
    public String createShowSeats(@RequestBody AddShowSeatsRequest addShowSeatsRequest){
        return showService.createShowSeats(addShowSeatsRequest);
    }
}
