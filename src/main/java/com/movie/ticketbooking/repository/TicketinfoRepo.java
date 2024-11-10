package com.movie.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.ticketbooking.entity.TicketInfo;

public interface TicketinfoRepo extends JpaRepository<TicketInfo, String> {

}