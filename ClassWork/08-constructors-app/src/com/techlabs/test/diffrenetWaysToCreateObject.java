package com.techlabs.test;

import com.techlabs.model.Account;

public class diffrenetWaysToCreateObject {

	public static void main(String[] args) {

//		Using newInstance() method
		try {
			Class reflectionAccount = Class.forName("com.techlabs.model.Account");

			Account account1 = (Account) reflectionAccount.newInstance();
		}

		catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
