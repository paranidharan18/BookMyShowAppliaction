package com.webServerProject.SpringProject1.TicketBookingController;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webServerProject.SpringProject1.PvrRepository.PvrMovieDetails;
import com.webServerProject.SpringProject1.TicketBookingServices.AvailableStatus;
import com.webServerProject.SpringProject1.TicketBookingServices.BookingDetailsRequest;
import com.webServerProject.SpringProject1.TicketBookingServices.BookingDetailsResponse;
import com.webServerProject.SpringProject1.TicketBookingServices.TicketAvilableDetails;
import com.webServerProject.SpringProject1.TicketBookingServices.TicketBookingServices;

@RestController
@RequestMapping(value = "/WelcomeToPvr")
public class TicketBookingController {
	@Autowired
	TicketBookingServices services;
	
	@GetMapping(value = "")
	public String WelcomePage() {
		return services.WelcomeMessage();
	}
	
	@GetMapping(value = "/AllMovies")
	public Map<Integer,TicketAvilableDetails> getAllDetails(){
		return services.AvailableMovies();
	}
	
	@GetMapping(value = "/{MovieId}/MovieDetails")
	public Optional<PvrMovieDetails> getMovieDetails(@PathVariable int MovieId){
		return services.getMovieDetails(MovieId);
	}
	
	@GetMapping(value = "/{MovieId}/MovieShowTime")
	public String getMovieShowTime(@PathVariable int MovieId){
		return services.getMovieShowTime(MovieId);
	}
	
	@PostMapping(value = "/AvailableStatus")
	public AvailableStatus getMovieStatus(@RequestBody BookingDetailsRequest bookingDetailsRequest) {
		return services.getAvailableStatus(bookingDetailsRequest);
	}
	
	@PostMapping(value = "/BookTicket")
	public BookingDetailsResponse bookTicket(@RequestBody BookingDetailsRequest bookingDetailsRequest) {
		return services.bookTicket(bookingDetailsRequest);
	}
	
	@PostMapping(value = "/ConfirmBooking")
	public String confirmBooking(@RequestBody BookingDetailsResponse bookingDetailsResponse) {
		return services.confirmBooking(bookingDetailsResponse);
	}
	
	@PostMapping(value = "/CancelBooking")
	public String cancelBooking(@RequestBody BookingDetailsResponse bookingDetailsResponse) {
		return services.cancelBooking(bookingDetailsResponse);
	}
}
