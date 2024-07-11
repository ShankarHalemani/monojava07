package com.techlabs.staticTest;

import com.techlabs.model.Account;

public class AccountTest {

	public static void main(String[] args) {
		Account account1 = new Account(1234567, "Shankar", 200000);
		account1.displayAccountInfo();

		Account account2 = new Account(2345678, "Luffy", 30000000);
		account2.displayAccountInfo();

		Account account3 = new Account(3456789, "Zoro", 12000000);
		account3.displayAccountInfo();

		Account.totalAccounts();

	}

}
