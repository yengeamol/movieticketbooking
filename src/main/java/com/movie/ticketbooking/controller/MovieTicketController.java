package com.movie.ticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.ticketbooking.dto.MovieTicketAcknowledgement;
import com.movie.ticketbooking.dto.MovieTicketRequest;
import com.movie.ticketbooking.service.MovieTicketService;


@RestController
public class MovieTicketController {
	
	@Autowired
	MovieTicketService service;
	
	@PostMapping("/bookMovieTicket")
	public MovieTicketAcknowledgement bookTicket(@RequestBody MovieTicketRequest request) {
		return service.bookMovieTicket(request);
	}
	
	

}