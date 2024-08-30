package com.webServerProject.SpringProject1.CinemaManagementService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webServerProject.SpringProject1.RepositoryLayer.TheatreListRepository;
import com.webServerProject.SpringProject1.RepositoryLayer.TheatreDetails;
import com.webServerProject.SpringProject1.RepositoryLayer.TheatreDetailsRepository;
import com.webServerProject.SpringProject1.RepositoryLayer.Theatre_List;

@Service
public class CinemaManagementService {
	@Autowired
	TheatreListRepository theatreListRepository;
	@Autowired
	TheatreDetailsRepository theatreDetailsRepository;
	Map<Integer, Theatre_List> theatreList = new HashMap<Integer, Theatre_List>();
	Map<Integer, TheatreDetails> theatreDetails = new HashMap<Integer, TheatreDetails>();

	public String welcomeMessage() {
		return "Welcome to BookMyShow" + "\n" + "Select your theatre";
	}

	public List<Theatre_List> getListOfTheatres() {
		List<Theatre_List> lists = theatreListRepository.findAll();
		return lists;
	}

	public Optional<TheatreDetails> getDetailsofTheatres(int TheatreId) {
		Optional<TheatreDetails> lists = theatreDetailsRepository.findById(TheatreId);
		return lists;
	}

	public List<String> getShowTime(int TheatreId) {
		Optional<TheatreDetails> lists = theatreDetailsRepository.findById(TheatreId);
		List<String> showTime = lists.get().getShowTimes();
		return showTime;
	}
}
