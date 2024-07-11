package com.techlabs.exceptions;

public class AgeNotValidException extends Exception {
	public String getMessage() {
		return "Age is not valid";
	}
}
