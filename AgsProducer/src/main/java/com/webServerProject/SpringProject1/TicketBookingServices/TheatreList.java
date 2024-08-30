package com.webServerProject.SpringProject1.TicketBookingServices;

public class TheatreList {
	private String theatreName;
	private int theatreId;
	public TheatreList() {}
	public TheatreList(String theatreName, int theatreId) {
		super();
		this.theatreName = theatreName;
		this.theatreId = theatreId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
}
