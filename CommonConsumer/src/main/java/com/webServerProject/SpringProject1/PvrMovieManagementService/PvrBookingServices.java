package com.webServerProject.SpringProject1.PvrMovieManagementService;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.webServerProject.SpringProject1.PromotionsAndDiscountsServices.PromotionsAndDiscountServices;
import com.webServerProject.SpringProject1.RepositoryLayer.Theatre_List;

@Service
public class PvrBookingServices {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	PromotionsAndDiscountServices promotionsAndDiscountServices;
	Map<Integer, Theatre_List> theatreList = new HashMap<Integer, Theatre_List>();

	public ResponseEntity<PvrAvailableStatus> getMovieStatusFromPvr(PvrBookingDetailsRequest pvrBookingDetailsRequest) {
		String URL = "http://localhost:9090/WelcomeToPvr/AvailableStatus";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<PvrBookingDetailsRequest> httpEntity = new HttpEntity<PvrBookingDetailsRequest>(
				pvrBookingDetailsRequest, headers);
		ResponseEntity<PvrAvailableStatus> availableStatus = restTemplate.exchange(URL, HttpMethod.POST, httpEntity,
				new ParameterizedTypeReference<PvrAvailableStatus>() {
				});
		return availableStatus;
	}

	public PvrBookingDetailsResponse bookTicketFromPvr(PvrBookingDetailsRequest pvrBookingDetailsRequest, String Coupon)
			throws IOException {
		String URL = "http://localhost:9090/WelcomeToPvr/BookTicket";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<PvrBookingDetailsRequest> httpEntity = new HttpEntity<PvrBookingDetailsRequest>(
				pvrBookingDetailsRequest, headers);
		ResponseEntity<PvrBookingDetailsResponse> bookingDetails = restTemplate.exchange(URL, HttpMethod.POST,
				httpEntity, new ParameterizedTypeReference<PvrBookingDetailsResponse>() {
				});
		PvrBookingDetailsResponse updatedPvrBookingDetailsResponse = bookingDetails.getBody();
		if (Coupon.equals("Coupon1")) {
			updatedPvrBookingDetailsResponse = applyCoupon(updatedPvrBookingDetailsResponse);
		}
		return updatedPvrBookingDetailsResponse;
	}

	public PvrBookingDetailsResponse applyCoupon(PvrBookingDetailsResponse updatedPvrBookingDetailsResponse) {
		String URL1 = "http://localhost:8080/WelcomeToBookMyShow/PVR/ApplyPromoCode";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<PvrBookingDetailsResponse> httpEntity = new HttpEntity<PvrBookingDetailsResponse>(
				updatedPvrBookingDetailsResponse, headers);
		ResponseEntity<PvrBookingDetailsResponse> bookingDetails = restTemplate.exchange(URL1, HttpMethod.POST,
				httpEntity, new ParameterizedTypeReference<PvrBookingDetailsResponse>() {
				});
		return bookingDetails.getBody();
	}

	public ResponseEntity<String> confirmTicketFromPvr(PvrBookingDetailsResponse pvrBookingDetailsResponse)
			throws IOException {
		String URL = "http://localhost:9090/WelcomeToPvr/ConfirmBooking";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<PvrBookingDetailsResponse> httpEntity = new HttpEntity<PvrBookingDetailsResponse>(
				pvrBookingDetailsResponse, headers);
		ResponseEntity<String> bookingDetails = restTemplate.exchange(URL, HttpMethod.POST, httpEntity,
				new ParameterizedTypeReference<String>() {
				});
		printReceipt(pvrBookingDetailsResponse);
		return bookingDetails;
	}

	public ResponseEntity<String> cancelTicketFromPvr(PvrBookingDetailsResponse pvrBookingDetailsResponse) {
		String URL = "http://localhost:9090/WelcomeToPvr/CancelBooking";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<PvrBookingDetailsResponse> httpEntity = new HttpEntity<PvrBookingDetailsResponse>(
				pvrBookingDetailsResponse, headers);
		ResponseEntity<String> bookingDetails = restTemplate.exchange(URL, HttpMethod.POST, httpEntity,
				new ParameterizedTypeReference<String>() {
				});
		return bookingDetails;
	}

	public static void printReceipt(PvrBookingDetailsResponse pvrBookingDetailsResponse) throws IOException {
		PDDocument document = new PDDocument();
		String BookingDetailsResponse = pvrBookingDetailsResponse.toString();
		try {
			PDPage page = new PDPage();
			document.addPage(page);
			PDPageContentStream contentStream = new PDPageContentStream(document, page);
			contentStream.beginText();
			contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
			contentStream.newLineAtOffset(100, 700);
			String[] lines = BookingDetailsResponse.split("\n");
			for (String line : lines) {
				contentStream.showText(line);
				contentStream.newLineAtOffset(0, -15);
			}
			contentStream.endText();
			contentStream.close();
			document.save("C:\\Users\\LENOVO\\Downloads\\Ticket Booking Receipt.pdf");
			document.close();
			System.out.println("PDF created successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}