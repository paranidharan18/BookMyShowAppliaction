package com.webServerProject.SpringProject1.CommonController;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webServerProject.SpringProject1.AgsMovieManagementServices.AgsAvailableStatus;
import com.webServerProject.SpringProject1.AgsMovieManagementServices.AgsBookingDetailsRequest;
import com.webServerProject.SpringProject1.AgsMovieManagementServices.AgsBookingDetailsResponse;
import com.webServerProject.SpringProject1.AgsMovieManagementServices.AgsBookingServices;
import com.webServerProject.SpringProject1.AgsMovieManagementServices.AgsMovieManagementService;
import com.webServerProject.SpringProject1.AgsMovieManagementServices.AgsTicketAvilableDetails;
import com.webServerProject.SpringProject1.AgsRepository.AgsMovieDetails;
import com.webServerProject.SpringProject1.CinemaManagementService.CinemaManagementService;
import com.webServerProject.SpringProject1.CommonServices.CommonServices;
import com.webServerProject.SpringProject1.NotificationService.NotificationService;
import com.webServerProject.SpringProject1.PromotionsAndDiscountsServices.PromotionsAndDiscountServices;
import com.webServerProject.SpringProject1.PvrMovieManagementService.PvrAvailableStatus;
import com.webServerProject.SpringProject1.PvrMovieManagementService.PvrBookingDetailsRequest;
import com.webServerProject.SpringProject1.PvrMovieManagementService.PvrBookingDetailsResponse;
import com.webServerProject.SpringProject1.PvrMovieManagementService.PvrBookingServices;
import com.webServerProject.SpringProject1.PvrMovieManagementService.PvrMovieManagementService;
import com.webServerProject.SpringProject1.PvrMovieManagementService.PvrTicketAvilableDetails;
import com.webServerProject.SpringProject1.PvrRepository.PvrMovieDetails;
import com.webServerProject.SpringProject1.RepositoryLayer.TheatreDetails;
import com.webServerProject.SpringProject1.RepositoryLayer.Theatre_List;

@RestController
@RequestMapping(value = "/WelcomeToBookMyShow", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
public class TicketBookingController {
	@Autowired
	PvrMovieManagementService pvrMovieManagementService;
	@Autowired
	AgsMovieManagementService agsMovieManagementService;
	@Autowired
	PvrBookingServices pvrBookingServices;
	@Autowired
	AgsBookingServices agsBookingServices;
	@Autowired
	CommonServices commonServices;
	@Autowired
	CinemaManagementService cinemaManagementService;
	@Autowired
	NotificationService notificationService;
	@Autowired
	PromotionsAndDiscountServices promotionsAndDiscountServices;

	@GetMapping(value = "")
	public String WelcomePage() {
		return commonServices.welcomeMessage();
	}

//	 ----------------------------------------------CinemaManagementService--------------------------------------------------

	@GetMapping(value = "/ListAllCinemas")
	public List<Theatre_List> getListOfTheatres() {
		return cinemaManagementService.getListOfTheatres();
	}

	@GetMapping(value = "/{TheatreId}/CinemaDetails")
	public Optional<TheatreDetails> getDetailsofTheatres(@PathVariable int TheatreId) {
		return cinemaManagementService.getDetailsofTheatres(TheatreId);
	}

	@GetMapping(value = "/{TheatreId}/ShowTimes")
	public List<String> getShowTime(@PathVariable int TheatreId) {
		return cinemaManagementService.getShowTime(TheatreId);
	}

//	 ----------------------------------------------PvrMovieManagementServices--------------------------------------------------

	@GetMapping(value = "/PVR/ListAllMovies")
	public ResponseEntity<Map<Integer, PvrTicketAvilableDetails>> getAllMoviesFromPvr() {
		return pvrMovieManagementService.getAllMoviesFromPvr();
	}

	@GetMapping(value = "/{MovieId}/PVR/MovieDetails")
	public ResponseEntity<Optional<PvrMovieDetails>> getMovieDetailsFromPvr(@PathVariable int MovieId) {
		return pvrMovieManagementService.getMovieDetailsFromPvr(MovieId);
	}

	@GetMapping(value = "/{MovieId}/PVR/ShowTimes")
	public ResponseEntity<String> getShowTimesFromPvr(@PathVariable int MovieId) {
		return pvrMovieManagementService.getShowTimesFromPvr(MovieId);
	}

//	 ----------------------------------------------AgsMovieManagementServices--------------------------------------------------

	@GetMapping(value = "/AGS/ListAllMovies")
	public ResponseEntity<Map<Integer, AgsTicketAvilableDetails>> getAllMoviesFromAgs() {
		return agsMovieManagementService.getAllMoviesFromAgs();
	}

	@GetMapping(value = "/{MovieId}/AGS/MovieDetails")
	public ResponseEntity<Optional<AgsMovieDetails>> getMovieDetailsFromAgs(@PathVariable int MovieId) {
		return agsMovieManagementService.getMovieDetailsFromAgs(MovieId);
	}

	@GetMapping(value = "/{MovieId}/AGS/ShowTimes")
	public ResponseEntity<String> getShowTimesFromAgs(@PathVariable int MovieId) {
		return agsMovieManagementService.getShowTimesFromAgs(MovieId);
	}
	
//	 ----------------------------------------------PvrBookingservice--------------------------------------------------

	@PostMapping(value = "/PVR/CheckSeatAvailability")
	public ResponseEntity<PvrAvailableStatus> getMovieStatusFromPvr(
			@RequestBody PvrBookingDetailsRequest pvrBookingDetailsRequest) {
		return pvrBookingServices.getMovieStatusFromPvr(pvrBookingDetailsRequest);
	}

	@PostMapping(value = "/PVR/BookTicket/{promocode}")
	public PvrBookingDetailsResponse bookTicketFromPvr(@RequestBody PvrBookingDetailsRequest pvrBookingDetailsRequest,
			@PathVariable String promocode) throws IOException {
		return pvrBookingServices.bookTicketFromPvr(pvrBookingDetailsRequest, promocode);
	}

	@PostMapping(value = "/PVR/ConfirmBooking")
	public ResponseEntity<String> confirmTicketFromPvr(@RequestBody PvrBookingDetailsResponse pvrBookingDetailsResponse)
			throws IOException {
		return pvrBookingServices.confirmTicketFromPvr(pvrBookingDetailsResponse);
	}

	@PostMapping(value = "/PVR/CancelBooking")
	public ResponseEntity<String> cancelTicketFromPvr(
			@RequestBody PvrBookingDetailsResponse pvrBookingDetailsResponse) {
		return pvrBookingServices.cancelTicketFromPvr(pvrBookingDetailsResponse);
	}

//	 ----------------------------------------------AgsBookingservice--------------------------------------------------

	@PostMapping(value = "/AGS/CheckSeatAvailability")
	public ResponseEntity<AgsAvailableStatus> getMovieStatusFromAgs(
			@RequestBody AgsBookingDetailsRequest agsBookingDetailsRequest) {
		return agsBookingServices.getMovieStatusFromAgs(agsBookingDetailsRequest);
	}

	@PostMapping(value = "/AGS/BookTicket/{promocode}")
	public AgsBookingDetailsResponse bookTicketFromAgs(@RequestBody AgsBookingDetailsRequest agsBookingDetailsRequest,
			@PathVariable String promocode) throws IOException {
		return agsBookingServices.bookTicketFromAgs(agsBookingDetailsRequest, promocode);
	}

	@PostMapping(value = "/AGS/ConfirmBooking")
	public ResponseEntity<String> confirmTicketFromAgs(@RequestBody AgsBookingDetailsResponse agsBookingDetailsResponse)
			throws IOException {
		return agsBookingServices.confirmTicketFromAgs(agsBookingDetailsResponse);
	}

	@PostMapping(value = "/AGS/CancelBooking")
	public ResponseEntity<String> cancelTicketFromAgs(
			@RequestBody AgsBookingDetailsResponse agsBookingDetailsResponse) {
		return agsBookingServices.cancelTicketFromAgs(agsBookingDetailsResponse);
	}

//	 ----------------------------------------------NotificationServiceForPvr--------------------------------------------------

	@PostMapping(value = "/PVR/NotificationViaEmail")
	public String notificationViaEmail(@RequestBody PvrBookingDetailsResponse pvrBookingDetailsResponse) {
		String requestBody = pvrBookingDetailsResponse.toString();
		return notificationService.notificationViaEmail(requestBody);
	}

	@PostMapping(value = "/PVR/ReceiptViaEmail")
	public String receiptViaEmail(@RequestBody PvrBookingDetailsResponse pvrBookingDetailsResponse) {
		String requestBody = pvrBookingDetailsResponse.toString();
		return notificationService.receiptViaEmail(requestBody);
	}

//	 ----------------------------------------------NotificationServiceForAgs--------------------------------------------------
	
	@PostMapping(value = "/AGS/NotificationViaEmail")
	public String notificationViaEmail(@RequestBody AgsBookingDetailsResponse agsBookingDetailsResponse) {
		String requestBody = agsBookingDetailsResponse.toString();
		return notificationService.notificationViaEmail(requestBody);
	}

	@PostMapping(value = "/AGS/ReceiptViaEmail")
	public String receiptViaEmail(@RequestBody AgsBookingDetailsResponse agsBookingDetailsResponse) {
		String requestBody = agsBookingDetailsResponse.toString();
		return notificationService.receiptViaEmail(requestBody);
	}
	
//	 ----------------------------------------------PromotionsAndDiscountServiceForPvr--------------------------------------------------

	@PostMapping(value = "/PVR/ApplyPromoCode")
	public PvrBookingDetailsResponse applyPromoCodeforPvr(@RequestBody PvrBookingDetailsResponse pvrBookingDetailsResponse) {
		return promotionsAndDiscountServices.applyPromoCodeForPvr(pvrBookingDetailsResponse);
	}

	@PostMapping(value = "/PVR/AvailablePromotions")
	public List<String> getAvailablePromotionsForPvr() {
		return promotionsAndDiscountServices.getAvailablePromotions();
	}
	
//	 ----------------------------------------------PromotionsAndDiscountServiceForAgs--------------------------------------------------

	@PostMapping(value = "/AGS/ApplyPromoCode")
	public AgsBookingDetailsResponse applyPromoCodeForAgs(@RequestBody AgsBookingDetailsResponse agsBookingDetailsResponse) {
		return promotionsAndDiscountServices.applyPromoCodeForAgs(agsBookingDetailsResponse);
	}

	@PostMapping(value = "/AGS/AvailablePromotions")
	public List<String> getAvailablePromotionsforAgs() {
		return promotionsAndDiscountServices.getAvailablePromotions();
	}
}
