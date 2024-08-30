package com.webServerProject.SpringProject1.PvrRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PvrMovieDetailsRepository extends JpaRepository<PvrMovieDetails,Integer>{
	
}