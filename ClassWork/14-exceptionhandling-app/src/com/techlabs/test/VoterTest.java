package com.techlabs.test;

import com.techlabs.exceptions.AgeNotValidException;
import com.techlabs.model.Voter;

public class VoterTest {

	public static void main(String[] args) {

		try {
			Voter vote1 = new Voter("Shankar", 22);
			Voter vote2 = new Voter("Prajwal", 16);

			vote1.Vote();
			vote2.Vote();
		}

		catch (AgeNotValidException e) {
			System.out.println(e.getMessage());
		}
	}

}
