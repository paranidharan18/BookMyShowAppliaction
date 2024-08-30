package com.webServerProject.SpringProject1.AgsRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgsMovieDetailsRepository extends JpaRepository<AgsMovieDetails,Integer>{
	
}