package com.webServerProject.SpringProject1.RepositoryLayer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "theatre_list")
public class Theatre_List {
	@Id
	private int theatre_id;
	private String theatre_name;

	public Theatre_List() {
	}

	public Theatre_List(int theatre_id, String theatre_name) {
		super();
		this.theatre_name = theatre_name;
		this.theatre_id = theatre_id;
	}

	public String getTheatreName() {
		return theatre_name;
	}

	public void setTheatreName(String theatre_name) {
		this.theatre_name = theatre_name;
	}

	public int getTheatreId() {
		return theatre_id;
	}

	public void setTheatreId(int theatre_id) {
		this.theatre_id = theatre_id;
	}
}