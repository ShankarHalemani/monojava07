package com.techlabs.model;

public class InputValidator {

	public boolean validateInput(String input, int minLength, int maxLength) {
		if (input == null || input.isEmpty() || input.length() < minLength || input.length() > maxLength) {
			return false;
		}
		return true;
	}

	public boolean validateUsername(String username) {
		return validateInput(username, 3, 20);
	}

	public boolean validatePassword(String password) {
		return validateInput(password, 8, 30);
	}

	public boolean validateEmail(String email) {
		if (!validateInput(email, 5, 50)) {
			return false;
		}
		if (!email.contains("@") || !email.contains(".")) {
			return false;
		}
		return true;
	}
}
