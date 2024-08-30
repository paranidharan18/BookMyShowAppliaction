package com.webServerProject.SpringProject1.PvrMovieManagementService;

public class PvrAvailableStatus {
	private PvrTicketAvilableDetails AvailableDetails;
	private String Status;

	public PvrAvailableStatus() {
	}

	public PvrAvailableStatus(PvrTicketAvilableDetails availableDetails, String status) {
		super();
		AvailableDetails = availableDetails;
		Status = status;
	}

	public PvrTicketAvilableDetails getAvailableDetails() {
		return AvailableDetails;
	}

	public void setAvailableDetails(PvrTicketAvilableDetails availableDetails) {
		AvailableDetails = availableDetails;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
}