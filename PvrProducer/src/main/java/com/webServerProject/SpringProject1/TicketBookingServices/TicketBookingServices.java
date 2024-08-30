package com.webServerProject.SpringProject1.TicketBookingServices;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webServerProject.SpringProject1.PvrRepository.PvrMovieDetails;
import com.webServerProject.SpringProject1.PvrRepository.PvrMovieDetailsRepository;
import com.webServerProject.SpringProject1.PvrRepository.PvrRepository;

@Service
public class TicketBookingServices {
	@Autowired
	PvrRepository pvrRepository;
	@Autowired
	PvrMovieDetailsRepository pvrMovieDetailsRepository;
	Map<Integer, TicketAvilableDetails> ListOfMovieDetails = new HashMap<Integer, TicketAvilableDetails>();

	public String WelcomeMessage() {
		return "Welcome to the PVR theatre" + "\n" + "Choose your movie";
	}

	public Map<Integer, TicketAvilableDetails> AvailableMovies() {
		List<TicketAvilableDetails> lists = pvrRepository.findAll();
		ListOfMovieDetails = lists.stream().collect(Collectors.toMap(TicketAvilableDetails::getMovieId, list -> list));
		return ListOfMovieDetails;
	}

	public Optional<PvrMovieDetails> getMovieDetails(int MovieId) {
		Optional<PvrMovieDetails> movieDetails = pvrMovieDetailsRepository.findById(MovieId);
		return movieDetails;
	}

	public String getMovieShowTime(int MovieId) {
		Optional<PvrMovieDetails> movieDetails = pvrMovieDetailsRepository.findById(MovieId);
		return movieDetails.get().getShowTimes();
	}

	public AvailableStatus getAvailableStatus(BookingDetailsRequest bookingDetailsRequest) {
		TicketAvilableDetails SelectedMovieDetails = ListOfMovieDetails.get(bookingDetailsRequest.getMovieId());
		AvailableStatus availableStatus;
		if (SelectedMovieDetails.getAvailableSeats() >= bookingDetailsRequest.getNoOfTickets()) {
			availableStatus = new AvailableStatus(SelectedMovieDetails, "Seats are Available");
		} else {
			availableStatus = new AvailableStatus(SelectedMovieDetails, "Seats are Unavailable");
		}
		return availableStatus;
	}

	public BookingDetailsResponse bookTicket(BookingDetailsRequest bookingDetailsRequest) {
		TicketAvilableDetails SelectedMovieDetails = ListOfMovieDetails.get(bookingDetailsRequest.getMovieId());
		BookingDetailsResponse responseDetails;
		LocalDateTime localDateTime = LocalDateTime.now();
		Random rand = new Random();
		String bookingDateAndTime = localDateTime.toString();
		String showDateAndTime = localDateTime.plusHours(2).toString();
		int bookingId = rand.nextInt(1000);
		if (SelectedMovieDetails.getAvailableSeats() >= bookingDetailsRequest.getNoOfTickets()) {
			responseDetails = new BookingDetailsResponse(SelectedMovieDetails.getMovieName(), "Booked successfully",
					bookingDateAndTime, showDateAndTime, bookingId, SelectedMovieDetails.getMovieId(),
					bookingDetailsRequest.getNoOfTickets(),
					SelectedMovieDetails.getTicketPrice() * bookingDetailsRequest.getNoOfTickets());
			int updatedAvailableSeats = SelectedMovieDetails.getAvailableSeats()
					- bookingDetailsRequest.getNoOfTickets();
			SelectedMovieDetails.setAvailableSeats(updatedAvailableSeats);
		} else {
			responseDetails = new BookingDetailsResponse(SelectedMovieDetails.getMovieName(), "Booking failed",
					bookingDateAndTime, showDateAndTime, bookingId, SelectedMovieDetails.getMovieId(),
					bookingDetailsRequest.getNoOfTickets(),
					SelectedMovieDetails.getTicketPrice() * bookingDetailsRequest.getNoOfTickets());
		}
		return responseDetails;
	}

	public String confirmBooking(BookingDetailsResponse bookingDetailsResponse) {
		TicketAvilableDetails SelectedMovieDetails = ListOfMovieDetails.get(bookingDetailsResponse.getMovieId());
		String result = "Booking failed";
		if (bookingDetailsResponse.getBookingStatus().equals("Booked successfully")) {
			pvrRepository.save(SelectedMovieDetails);
			result = "Booking Confirmed";
		}
		return result;
	}

	public String cancelBooking(BookingDetailsResponse bookingDetailsResponse) {
		TicketAvilableDetails SelectedMovieDetails = ListOfMovieDetails.get(bookingDetailsResponse.getMovieId());
		String result = "Cancellation process failed";
		if (bookingDetailsResponse.getBookingStatus().equals("Booked successfully")) {
			int updatedAvailableSeats = SelectedMovieDetails.getAvailableSeats()
					+ bookingDetailsResponse.getNoOfSeats();
			SelectedMovieDetails.setAvailableSeats(updatedAvailableSeats);
			pvrRepository.save(SelectedMovieDetails);
			result = "Cancelled Succeessfully";
		}
		return result;
	}
}