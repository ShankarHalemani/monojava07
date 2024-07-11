package com.techlabs.test;

import com.techlabs.model.Account;

public class AccountTest {

	public static void main(String[] args) {

		Account acc1 = new Account();
		System.out.println("Account details");
		Account acc2 = new Account(910863458, "Savings", "Shankar", 30000);
		System.out.println("Account Number : " + acc2.getAccNum());
		System.out.println("Account Type : " + acc2.getAccType());
		System.out.println("Account name : " + acc2.getAccName());
		System.out.println("Account balance : " + acc2.getAccBalance());

	}

}
