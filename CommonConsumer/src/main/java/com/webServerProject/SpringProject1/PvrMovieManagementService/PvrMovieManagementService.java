package com.webServerProject.SpringProject1.PvrMovieManagementService;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.webServerProject.SpringProject1.PvrRepository.PvrMovieDetails;

@Service
public class PvrMovieManagementService {
	@Autowired
	RestTemplate restTemplate;

	public ResponseEntity<Map<Integer, PvrTicketAvilableDetails>> getAllMoviesFromPvr() {
		String URL = "http://localhost:9090/WelcomeToPvr/AllMovies";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> httpEntity = new HttpEntity<>(headers);
		ResponseEntity<Map<Integer, PvrTicketAvilableDetails>> ListOfMovies = restTemplate.exchange(URL, HttpMethod.GET,
				httpEntity, new ParameterizedTypeReference<Map<Integer, PvrTicketAvilableDetails>>() {
				});
		return ListOfMovies;
	}

	public ResponseEntity<Optional<PvrMovieDetails>> getMovieDetailsFromPvr(int MovieId) {
		String URL = "http://localhost:9090/WelcomeToPvr/" + MovieId + "/MovieDetails";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> httpEntity = new HttpEntity<>(headers);
		ResponseEntity<Optional<PvrMovieDetails>> MovieDetails = restTemplate.exchange(URL, HttpMethod.GET, httpEntity,
				new ParameterizedTypeReference<Optional<PvrMovieDetails>>() {
				});
		return MovieDetails;
	}

	public ResponseEntity<String> getShowTimesFromPvr(int MovieId) {
		String URL = "http://localhost:9090/WelcomeToPvr/" + MovieId + "/MovieShowTime";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> httpEntity = new HttpEntity<>(headers);
		ResponseEntity<String> MovieDetails = restTemplate.exchange(URL, HttpMethod.GET, httpEntity,
				new ParameterizedTypeReference<String>() {
				});
		return MovieDetails;
	}
}
