package com.webServerProject.SpringProject1.PvrMovieManagementService;

public class PvrTicketAvilableDetails {
	private String MovieName;
	private int TicketPrice, MovieId, AvailableSeats;

	public PvrTicketAvilableDetails() {
	}

	public PvrTicketAvilableDetails(String movieName, int ticketPrice, int movieId, int availableSeats) {
		super();
		MovieName = movieName;
		TicketPrice = ticketPrice;
		MovieId = movieId;
		AvailableSeats = availableSeats;
	}

	public String getMovieName() {
		return MovieName;
	}

	public void setMovieName(String movieName) {
		MovieName = movieName;
	}

	public int getTicketPrice() {
		return TicketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		TicketPrice = ticketPrice;
	}

	public int getMovieId() {
		return MovieId;
	}

	public void setMovieId(int movieId) {
		MovieId = movieId;
	}

	public int getAvailableSeats() {
		return AvailableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		AvailableSeats = availableSeats;
	}
}
