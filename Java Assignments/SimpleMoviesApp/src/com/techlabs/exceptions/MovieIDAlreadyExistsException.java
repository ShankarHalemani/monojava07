package com.techlabs.exceptions;

public class MovieIDAlreadyExistsException extends Exception {
	public String getMessage() {
		return "Movie with this current movie ID already exists, cannot add movie";
	}

}
