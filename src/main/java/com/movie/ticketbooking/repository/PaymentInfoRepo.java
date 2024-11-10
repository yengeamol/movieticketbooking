package com.movie.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.ticketbooking.entity.PaymentInfo;


public interface PaymentInfoRepo extends JpaRepository<PaymentInfo, Long> {

}