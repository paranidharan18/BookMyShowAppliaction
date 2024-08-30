package com.webServerProject.SpringProject1.AgsMovieManagementServices;

public class AgsAvailableStatus {
	private AgsTicketAvilableDetails AvailableDetails;
	private String Status;

	public AgsAvailableStatus() {
	}

	public AgsAvailableStatus(AgsTicketAvilableDetails availableDetails, String status) {
		super();
		AvailableDetails = availableDetails;
		Status = status;
	}

	public AgsTicketAvilableDetails getAvailableDetails() {
		return AvailableDetails;
	}

	public void setAvailableDetails(AgsTicketAvilableDetails availableDetails) {
		AvailableDetails = availableDetails;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
}