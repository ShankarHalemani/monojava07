package com.techlabs.exceptions;

public class CapacityFullException extends Exception {
	public String getMessage() {
		return "Capacity of File is Full. Cannot add anymore movies";
	}

}
