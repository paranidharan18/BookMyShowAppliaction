package com.webServerProject.SpringProject1.AgsMovieManagementServices;

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
public class AgsBookingServices {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	PromotionsAndDiscountServices promotionsAndDiscountServices;
	Map<Integer, Theatre_List> theatreList = new HashMap<Integer, Theatre_List>();

	public ResponseEntity<AgsAvailableStatus> getMovieStatusFromAgs(AgsBookingDetailsRequest agsBookingDetailsRequest) {
		String URL = "http://localhost:7070/WelcomeToAgs/AvailableStatus";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<AgsBookingDetailsRequest> httpEntity = new HttpEntity<AgsBookingDetailsRequest>(
				agsBookingDetailsRequest, headers);
		ResponseEntity<AgsAvailableStatus> availableStatus = restTemplate.exchange(URL, HttpMethod.POST, httpEntity,
				new ParameterizedTypeReference<AgsAvailableStatus>() {
				});
		return availableStatus;
	}

	public AgsBookingDetailsResponse bookTicketFromAgs(AgsBookingDetailsRequest agsBookingDetailsRequest, String Coupon)
			throws IOException {
		String URL = "http://localhost:7070/WelcomeToAgs/BookTicket";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<AgsBookingDetailsRequest> httpEntity = new HttpEntity<AgsBookingDetailsRequest>(
				agsBookingDetailsRequest, headers);
		ResponseEntity<AgsBookingDetailsResponse> bookingDetails = restTemplate.exchange(URL, HttpMethod.POST,
				httpEntity, new ParameterizedTypeReference<AgsBookingDetailsResponse>() {
				});
		AgsBookingDetailsResponse updatedPvrBookingDetailsResponse = bookingDetails.getBody();
		if (Coupon.equals("Coupon1")) {
			updatedPvrBookingDetailsResponse = applyCoupon(updatedPvrBookingDetailsResponse);
		}
		return updatedPvrBookingDetailsResponse;
	}

	public AgsBookingDetailsResponse applyCoupon(AgsBookingDetailsResponse updatedAgsBookingDetailsResponse) {
		String URL1 = "http://localhost:8080/WelcomeToBookMyShow/AGS/ApplyPromoCode";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<AgsBookingDetailsResponse> httpEntity = new HttpEntity<AgsBookingDetailsResponse>(
				updatedAgsBookingDetailsResponse, headers);
		ResponseEntity<AgsBookingDetailsResponse> bookingDetails = restTemplate.exchange(URL1, HttpMethod.POST,
				httpEntity, new ParameterizedTypeReference<AgsBookingDetailsResponse>() {
				});
		return bookingDetails.getBody();
	}

	public ResponseEntity<String> confirmTicketFromAgs(AgsBookingDetailsResponse agsBookingDetailsResponse)
			throws IOException {
		String URL = "http://localhost:7070/WelcomeToAgs/ConfirmBooking";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<AgsBookingDetailsResponse> httpEntity = new HttpEntity<AgsBookingDetailsResponse>(
				agsBookingDetailsResponse, headers);
		ResponseEntity<String> bookingDetails = restTemplate.exchange(URL, HttpMethod.POST, httpEntity,
				new ParameterizedTypeReference<String>() {
				});
		printReceipt(agsBookingDetailsResponse);
		return bookingDetails;
	}

	public ResponseEntity<String> cancelTicketFromAgs(AgsBookingDetailsResponse agsBookingDetailsResponse) {
		String URL = "http://localhost:7070/WelcomeToAgs/CancelBooking";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<AgsBookingDetailsResponse> httpEntity = new HttpEntity<AgsBookingDetailsResponse>(
				agsBookingDetailsResponse, headers);
		ResponseEntity<String> bookingDetails = restTemplate.exchange(URL, HttpMethod.POST, httpEntity,
				new ParameterizedTypeReference<String>() {
				});
		return bookingDetails;
	}

	public static void printReceipt(AgsBookingDetailsResponse agsBookingDetailsResponse) throws IOException {
		PDDocument document = new PDDocument();
		String BookingDetailsResponse = agsBookingDetailsResponse.toString();
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
			System.out.println("PDF createdq successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}