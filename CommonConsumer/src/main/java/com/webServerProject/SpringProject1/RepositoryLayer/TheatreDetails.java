package com.webServerProject.SpringProject1.RepositoryLayer;

import java.util.List;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "theatre_list")
public class TheatreDetails {
	@Column(name = "theatre_name")
	private String TheatreName;
	@Column(name = "theatre_id")
	@Id
	private int TheatreId;
	@ElementCollection
	@CollectionTable(name = "show_times", joinColumns = @JoinColumn(name = "theatre_id"))
	@Column(name = "show_times")
	private List<String> ShowTimes;

	public TheatreDetails() {
	}

	public TheatreDetails(String theatreName, int theatreId, List<String> showTimes) {
		super();
		TheatreName = theatreName;
		TheatreId = theatreId;
		ShowTimes = showTimes;
	}

	public String getTheatreName() {
		return TheatreName;
	}

	public void setTheatreName(String theatreName) {
		TheatreName = theatreName;
	}

	public int getTheatreId() {
		return TheatreId;
	}

	public void setTheatreId(int theatreId) {
		TheatreId = theatreId;
	}

	public List<String> getShowTimes() {
		return ShowTimes;
	}

	public void setShowTimes(List<String> showTimes) {
		ShowTimes = showTimes;
	}
}
