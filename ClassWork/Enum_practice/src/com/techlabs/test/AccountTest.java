package com.techlabs.test;

import java.util.Scanner;

import com.techlabs.model.Account;
import com.techlabs.model.AccountType;

public class AccountTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Account[] accounts = new Account[3];

		for (int i = 0; i < accounts.length; i++) {

			accounts[i] = new Account();

			System.out.println("Enter account number");
			accounts[i].setAccountNumber(scanner.nextLong());

			System.out.println("Enter account holder name");
			accounts[i].setAccountName(scanner.next());

			System.out.println("Enter account balance");
			accounts[i].setBalance(scanner.nextInt());

			System.out.println("Enter account type: Press 1 for Savings, Press 2 for current");
			int accountTypeNum = scanner.nextInt();

			if (accountTypeNum == 1) {
				accounts[i].setAccountType(AccountType.Savings);
			}

			else if (accountTypeNum == 2) {
				accounts[i].setAccountType(AccountType.Current);
			}
		}

		for (int i = 0; i < accounts.length; i++) {
			System.out.println(accounts[i]);
			System.out.println();
		}

		for (Account account : accounts) {
			System.out.println(account);
			System.out.println();
		}

		scanner.close();

	}

}
