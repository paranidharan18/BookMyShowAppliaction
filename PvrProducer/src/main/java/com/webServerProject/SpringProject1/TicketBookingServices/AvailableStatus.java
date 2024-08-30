package com.webServerProject.SpringProject1.TicketBookingServices;

public class AvailableStatus {
	private TicketAvilableDetails AvailableDetails;
	private String Status;
	public AvailableStatus() {}
	public AvailableStatus(TicketAvilableDetails availableDetails, String status) {
		super();
		AvailableDetails = availableDetails;
		Status = status;
	}
	public TicketAvilableDetails getAvailableDetails() {
		return AvailableDetails;
	}
	public void setAvailableDetails(TicketAvilableDetails availableDetails) {
		AvailableDetails = availableDetails;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
}