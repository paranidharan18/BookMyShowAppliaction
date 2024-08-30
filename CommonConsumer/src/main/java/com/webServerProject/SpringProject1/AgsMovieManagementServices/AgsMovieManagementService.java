package com.webServerProject.SpringProject1.AgsMovieManagementServices;

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

import com.webServerProject.SpringProject1.AgsRepository.AgsMovieDetails;

@Service
public class AgsMovieManagementService {
	@Autowired
	RestTemplate restTemplate;

	public ResponseEntity<Map<Integer, AgsTicketAvilableDetails>> getAllMoviesFromAgs() {
		String URL = "http://localhost:7070/WelcomeToAgs/AllMovies";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> httpEntity = new HttpEntity<>(headers);
		ResponseEntity<Map<Integer, AgsTicketAvilableDetails>> ListOfMovies = restTemplate.exchange(URL, HttpMethod.GET,
				httpEntity, new ParameterizedTypeReference<Map<Integer, AgsTicketAvilableDetails>>() {
				});
		return ListOfMovies;
	}

	public ResponseEntity<Optional<AgsMovieDetails>> getMovieDetailsFromAgs(int MovieId) {
		String URL = "http://localhost:7070/WelcomeToAgs/" + MovieId + "/MovieDetails";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> httpEntity = new HttpEntity<>(headers);
		ResponseEntity<Optional<AgsMovieDetails>> MovieDetails = restTemplate.exchange(URL, HttpMethod.GET, httpEntity,
				new ParameterizedTypeReference<Optional<AgsMovieDetails>>() {
				});
		return MovieDetails;
	}

	public ResponseEntity<String> getShowTimesFromAgs(int MovieId) {
		String URL = "http://localhost:7070/WelcomeToAgs/" + MovieId + "/MovieShowTime";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> httpEntity = new HttpEntity<>(headers);
		ResponseEntity<String> MovieDetails = restTemplate.exchange(URL, HttpMethod.GET, httpEntity,
				new ParameterizedTypeReference<String>() {
				});
		return MovieDetails;
	}
}
