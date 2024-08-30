package com.webServerProject.SpringProject1.PvrRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webServerProject.SpringProject1.TicketBookingServices.TicketAvilableDetails;

@Repository
public interface PvrRepository extends JpaRepository<TicketAvilableDetails,Integer>{
	
}