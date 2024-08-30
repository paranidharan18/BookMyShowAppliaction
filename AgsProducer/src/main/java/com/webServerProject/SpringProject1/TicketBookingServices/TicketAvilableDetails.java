package com.webServerProject.SpringProject1.TicketBookingServices;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ags_movie_list")
public class TicketAvilableDetails {
	@Column(name = "movie_name")
	private String MovieName;
	@Column(name = "ticket_price")
	private int TicketPrice;
	@Column(name = "movie_id")
	@Id
	private int MovieId;
	@Column(name = "available_seats")
	private int AvailableSeats;
	public TicketAvilableDetails() {}
	public TicketAvilableDetails(String movieName, int ticketPrice, int movieId, int availableSeats) {
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
