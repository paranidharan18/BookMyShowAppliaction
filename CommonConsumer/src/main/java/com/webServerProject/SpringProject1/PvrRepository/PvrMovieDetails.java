package com.webServerProject.SpringProject1.PvrRepository;

public class PvrMovieDetails {
	private String movieName;
	private int movieId;
	private String synopsis;
	private String cast;
	private int rating;
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
