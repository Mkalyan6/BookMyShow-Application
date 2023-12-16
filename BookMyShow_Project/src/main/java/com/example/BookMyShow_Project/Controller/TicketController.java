package com.example.BookMyShow_Project.Controller;

import com.example.BookMyShow_Project.Models.Show;
import com.example.BookMyShow_Project.RequestDTOs.BookTicketRequest;
import com.example.BookMyShow_Project.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @PostMapping("/ConfirmTicket")
    public String addTicket(@RequestBody BookTicketRequest bookTicketRequest) {
        return ticketService.addTicket(bookTicketRequest);
    }
}
