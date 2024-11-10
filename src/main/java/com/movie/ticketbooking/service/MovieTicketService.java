package com.movie.ticketbooking.service;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movie.ticketbooking.dto.MovieTicketAcknowledgement;
import com.movie.ticketbooking.dto.MovieTicketRequest;
import com.movie.ticketbooking.entity.PaymentInfo;
import com.movie.ticketbooking.entity.TicketInfo;
import com.movie.ticketbooking.repository.PaymentInfoRepo;
import com.movie.ticketbooking.repository.TicketinfoRepo;
import com.movie.ticketbooking.utility.ValidatePaymentInfo;


@Service
public class MovieTicketService {
	
	  @Autowired
	  TicketinfoRepo ticketinfoRepo;
	  
	  @Autowired
	  PaymentInfoRepo paymentInfoRepo;
	  
	  @Transactional
	  public MovieTicketAcknowledgement bookMovieTicket(MovieTicketRequest request) {
		  TicketInfo ticketInfo = request.getTicketInfo();
		  ticketInfo =   ticketinfoRepo.save(ticketInfo);
		  
		  PaymentInfo paymentInfo = request.getPaymentInfo();
		  
		  ValidatePaymentInfo.validateCreditLimit(paymentInfo.getAccountNo(), ticketInfo.getTicketPrize());
		  
		  paymentInfo.setTicketId(ticketInfo.getId());
		  paymentInfo.setAmount(ticketInfo.getTicketPrize());
		  
		  paymentInfoRepo.save(paymentInfo);
		  
		  return new MovieTicketAcknowledgement("SUCCESSS", ticketInfo.getTicketPrize(),UUID.randomUUID().toString().split("-")[0], ticketInfo);
	  }

}