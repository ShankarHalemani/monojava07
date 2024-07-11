package com.techlabs.test;

import java.util.Scanner;

import com.techlabs.model.Account;

public class AccountTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		long accountNumber;
		String accountType;
		String name;
		int balance;

		Account acc1 = new Account();
		System.out.println("Enter account number");
		accountNumber = scanner.nextLong();
		acc1.setAccNumber(accountNumber);

		System.out.println("Enter account type");
		accountType = scanner.next();
		acc1.setAccType(accountType);

		System.out.println("Enter account name ");
		name = scanner.next();
		acc1.setAccName(name);

		System.out.println("Enter account balance");
		balance = scanner.nextInt();
		acc1.setBalance(balance);

		System.out.println("Account 1 details");
		System.out.println("Account number : " + acc1.getAccNumber());
		System.out.println("Account type : " + acc1.getAccType());
		System.out.println("Account name : " + acc1.getAccname());
		System.out.println("Account balance : " + acc1.getAccBalance());

		System.out.println();

		Account acc2 = new Account();
		System.out.println("Enter account number");
		accountNumber = scanner.nextLong();
		acc2.setAccNumber(accountNumber);

		System.out.println("Enter account type");
		accountType = scanner.next();
		acc2.setAccType(accountType);

		System.out.println("Enter account name ");
		name = scanner.next();
		acc2.setAccName(name);

		System.out.println("Enter account balance");
		balance = scanner.nextInt();
		acc2.setBalance(balance);

		System.out.println("Account 2 details");
		System.out.println("Account number : " + acc2.getAccNumber());
		System.out.println("Account type : " + acc2.getAccType());
		System.out.println("Account name : " + acc2.getAccname());
		System.out.println("Account balance : " + acc2.getAccBalance());

		System.out.println();

		scanner.close();
	}

}
