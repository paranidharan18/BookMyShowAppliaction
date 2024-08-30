package com.webServerProject.SpringProject1.AgsRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webServerProject.SpringProject1.TicketBookingServices.TicketAvilableDetails;

@Repository
public interface AgsRepository extends JpaRepository<TicketAvilableDetails,Integer>{
	
}