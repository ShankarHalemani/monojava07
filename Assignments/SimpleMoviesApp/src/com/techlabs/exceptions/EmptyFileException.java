package com.techlabs.exceptions;

public class EmptyFileException extends Exception {
	public String getMessage() {
		return "There are no movies in the file to remove or display";
	}
}
