package com.webServerProject.SpringProject1.PvrMovieManagementService;

public class PvrBookingDetailsResponse {
	private String movieName, bookingStatus, bookingDateAndTime, showDateAndTime;
	private int bookingId, movieId, noOfSeats, ticketPrice;

	public PvrBookingDetailsResponse() {
	}

	public PvrBookingDetailsResponse(String movieName, String bookingStatus, String bookingDateAndTime,
			String showDateAndTime, int bookingId, int movieId, int noOfSeats, int ticketPrice) {
		super();
		this.movieName = movieName;
		this.bookingStatus = bookingStatus;
		this.bookingDateAndTime = bookingDateAndTime;
		this.showDateAndTime = showDateAndTime;
		this.bookingId = bookingId;
		this.movieId = movieId;
		this.noOfSeats = noOfSeats;
		this.ticketPrice = ticketPrice;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getBookingDateAndTime() {
		return bookingDateAndTime;
	}

	public void setBookingDateAndTime(String bookingDateAndTime) {
		this.bookingDateAndTime = bookingDateAndTime;
	}

	public String getShowDateAndTime() {
		return showDateAndTime;
	}

	public void setShowDateAndTime(String showDateAndTime) {
		this.showDateAndTime = showDateAndTime;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	@Override
	public String toString() {
		return "PvrBookingDetails" + "\n" + "MovieName : " + movieName + "\n" + "BookingStatus : " + bookingStatus
				+ "\n" + "BookingDateAndTime : " + bookingDateAndTime + "\n" + "ShowDateAndTime : " + showDateAndTime
				+ "\n" + "BookingId : " + bookingId + "\n" + "MovieId : " + movieId + "\n" + "NoOfSeats : " + noOfSeats
				+ "\n" + "TicketPrice : " + ticketPrice;
	}

}