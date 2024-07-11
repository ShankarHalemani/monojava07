package com.techlabs.test;

import java.util.Scanner;

import com.techlabs.model.InputValidator;

public class InputValidatorTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		InputValidator inputvalidate1 = new InputValidator();

		System.out.println("Enter usrname to validate");
		String userName = scanner.next();
		boolean userNameValidate = inputvalidate1.validateUsername(userName);

		if (userNameValidate) {
			System.out.println("Username is Valid");
		}

		if (userNameValidate == false) {
			System.out.println("Username is not valid");
		}

		System.out.println("Enter password to validate");
		String password = scanner.next();
		boolean passwordValidate = inputvalidate1.validatePassword(password);

		if (passwordValidate) {
			System.out.println("password is Valid");
		}

		if (passwordValidate == false) {
			System.out.println("password is not Valid");
		}

		System.out.println("Enter emailId to validate");
		String emailId = scanner.next();
		boolean emailIdValidate = inputvalidate1.validateEmail(emailId);

		if (emailIdValidate) {
			System.out.println("emailId is Valid");
		}

		if (emailIdValidate == false) {
			System.out.println("emailId is not Valid");
		}

		scanner.close();

	}

//	Do this using functions 

}
