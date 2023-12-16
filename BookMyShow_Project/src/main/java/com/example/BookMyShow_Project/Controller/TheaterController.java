package com.example.BookMyShow_Project.Controller;

import com.example.BookMyShow_Project.RequestDTOs.AddTheaterRequest;
import com.example.BookMyShow_Project.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.coyote.http11.Constants.a;

@RestController
@RequestMapping("/Theater")
public class TheaterController {
    @Autowired
    TheaterService theaterservice;
    @PostMapping("/addTheater")
    public ResponseEntity addTheater(@RequestBody AddTheaterRequest addTheaterRequest){

        return theaterservice.addTheater(addTheaterRequest);

    }
}
