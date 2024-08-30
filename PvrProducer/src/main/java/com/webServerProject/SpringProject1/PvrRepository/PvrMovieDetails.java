package com.webServerProject.SpringProject1.PvrRepository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pvr_movie_details")
public class PvrMovieDetails {
	@Column(name = "movie_name")
	private String movieName;
	@Column(name = "movie_id")
	@Id
	private int movieId;
	@Column(name = "synopsis")
	private String synopsis;
	@Column(name = "cast")
	private String cast;
	@Column(name = "rating")
	private int rating;
	@Column(name = "show_times")
	private String showTimes;

	public PvrMovieDetails() {
	}

	public PvrMovieDetails(String movieName, int movieId, String synopsis, String cast, int rating, String showTimes) {
		super();
		this.movieName = movieName;
		this.movieId = movieId;
		this.synopsis = synopsis;
		this.cast = cast;
		this.rating = rating;
		this.showTimes = showTimes;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getShowTimes() {
		return showTimes;
	}

	public void setShowTimes(String showTimes) {
		this.showTimes = showTimes;
	}

}
