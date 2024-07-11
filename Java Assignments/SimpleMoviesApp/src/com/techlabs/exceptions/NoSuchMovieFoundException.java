package com.techlabs.exceptions;

public class NoSuchMovieFoundException extends Exception {
	public String getMessage() {
		return "There is no movie with that movie ID";
	}

}
