package com.webServerProject.SpringProject1.AgsMovieManagementServices;

//Request
public class AgsBookingDetailsRequest {
	private String MovieName;
	private int MovieId, NoOfTickets;

	public AgsBookingDetailsRequest() {
	}

	public AgsBookingDetailsRequest(String movieName, int movieId, int noOfTickets) {
		super();
		MovieName = movieName;
		MovieId = movieId;
		NoOfTickets = noOfTickets;
	}

	public String getMovieName() {
		return MovieName;
	}

	public void setMovieName(String movieName) {
		MovieName = movieName;
	}

	public int getMovieId() {
		return MovieId;
	}

	public void setMovieId(int movieId) {
		MovieId = movieId;
	}

	public int getNoOfTickets() {
		return NoOfTickets;
	}

	public void setNoOfTickets(int noOfTickets) {
		NoOfTickets = noOfTickets;
	}
}
