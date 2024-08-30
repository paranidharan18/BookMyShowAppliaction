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
import com.webServerProject.SpringProject1.RepositoryLayer.Theatre_List;

@Service
public class AgsTicketBookingServices {
	@Autowired
	RestTemplate restTemplate;
	Map<Integer, Theatre_List> theatreList = new HashMap<Integer, Theatre_List>();

	public Map<Integer, Theatre_List> AvailableTheatre() {
		return theatreList;
	}

	public ResponseEntity<Map<Integer, AgsTicketAvilableDetails>> getAllMovies() {
		String URL = "http://localhost:7070/WelcomeToAgs/AllMovies";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> httpEntity = new HttpEntity<>(headers);
		ResponseEntity<Map<Integer, AgsTicketAvilableDetails>> ListOfMovies = restTemplate.exchange(URL, HttpMethod.GET,
				httpEntity, new ParameterizedTypeReference<Map<Integer, AgsTicketAvilableDetails>>() {
				});
		return ListOfMovies;
	}

	public ResponseEntity<AgsAvailableStatus> getMovieStatus(AgsBookingDetailsRequest agsBookingDetailsRequest) {
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

	public ResponseEntity<AgsBookingDetailsResponse> bookTicket(AgsBookingDetailsRequest agsBookingDetailsRequest)
			throws IOException {
		String URL = "http://localhost:7070/WelcomeToAgs/BookTicket";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<AgsBookingDetailsRequest> httpEntity = new HttpEntity<AgsBookingDetailsRequest>(
				agsBookingDetailsRequest, headers);
		ResponseEntity<AgsBookingDetailsResponse> bookingDetails = restTemplate.exchange(URL, HttpMethod.POST,
				httpEntity, new ParameterizedTypeReference<AgsBookingDetailsResponse>() {
				});
		printReceipt(bookingDetails);
		return bookingDetails;
	}

	public static void printReceipt(ResponseEntity<AgsBookingDetailsResponse> bookingDetails) throws IOException {
		PDDocument document = new PDDocument();
		String pvrBookingDetailsResponse = bookingDetails.getBody().toString();
		try {
			PDPage page = new PDPage();
			document.addPage(page);
			PDPageContentStream contentStream = new PDPageContentStream(document, page);
			contentStream.beginText();
			contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
			contentStream.newLineAtOffset(100, 700);
			String[] lines = pvrBookingDetailsResponse.split("\n");
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