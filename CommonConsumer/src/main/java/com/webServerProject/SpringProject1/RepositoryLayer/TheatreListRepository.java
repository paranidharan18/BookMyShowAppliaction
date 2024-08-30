package com.webServerProject.SpringProject1.RepositoryLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreListRepository extends JpaRepository<Theatre_List, Integer> {

}