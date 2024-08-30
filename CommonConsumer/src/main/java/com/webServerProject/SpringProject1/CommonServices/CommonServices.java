package com.webServerProject.SpringProject1.CommonServices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webServerProject.SpringProject1.RepositoryLayer.TheatreListRepository;
import com.webServerProject.SpringProject1.RepositoryLayer.Theatre_List;

@Service
public class CommonServices {
	@Autowired
	TheatreListRepository theatreListRepository;
	Map<Integer, Theatre_List> theatreList = new HashMap<Integer, Theatre_List>();

	public String welcomeMessage() {
		return "Welcome to BookMyShow" + "\n" + "Select your theatre";
	}

	public Map<Integer, Theatre_List> getListOfTheatres() {
		List<Theatre_List> lists = theatreListRepository.findAll();
		theatreList = lists.stream().collect(Collectors.toMap(Theatre_List::getTheatreId, list -> list));
		return theatreList;
	}
}