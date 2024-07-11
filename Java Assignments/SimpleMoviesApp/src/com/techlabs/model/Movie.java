package com.techlabs.model;

import java.io.Serializable;

public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;
	private int movieID;
	private String movieName;
	private String genre;
	private int movieYear;

	public Movie(int movieID, String movieName, String genre, int movieYear) {
		this.movieID = movieID;
		this.movieName = movieName;
		this.genre = genre;
		this.movieYear = movieYear;
	}

	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getMovieYear() {
		return movieYear;
	}

	public void setMovieYear(int movieYear) {
		this.movieYear = movieYear;
	}

}
