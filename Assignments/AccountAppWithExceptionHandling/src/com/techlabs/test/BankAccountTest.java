package com.techlabs.test;

import java.util.Scanner;

import com.techlabs.exceptions.InsufficientFundsException;
import com.techlabs.exceptions.NegativeAmountException;
import com.techlabs.model.BankAccount;

public class BankAccountTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BankAccount bankAccount = null;

		boolean exit = false;

		while (!exit) {
			System.out.println("Choose");
			System.out.println("1. Create Bank Account");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Exit");

			int choice = scanner.nextInt();
			switch (choice) {

			case 1:
				System.out.println("Enter Account number");
				int accountNumber = scanner.nextInt();
				System.out.println("Enter Account balance");
				double accountBalance = scanner.nextDouble();
				bankAccount = new BankAccount(accountNumber, accountBalance);
				System.out.println("Account created\n");
				break;

			// Try to deposit negative amount to test NegativeAmountException
			case 2:
				System.out.println("Enter amount to be deposited");
				double amountToBeDeposited = scanner.nextDouble();
				try {
					bankAccount.deposite(amountToBeDeposited);
				}

				catch (NegativeAmountException e) {
					System.out.println(e.getMessage());
				}
				break;

			// Try to withdraw negative amount to test NegativeAmountException

			// Try to withdraw amount that is greater than balance to test
			// InsufficientFundsException
			case 3:
				System.out.println("Enter the amount to be withdrawn");
				double amountToBeWithdrawn = scanner.nextDouble();
				try {
					bankAccount.withdrawal(amountToBeWithdrawn);
				}

				catch (NegativeAmountException e) {
					System.out.println(e.getMessage());
				}

				catch (InsufficientFundsException e) {
					System.out.println(e.getMessage());
				}

				break;

			case 4:
				System.out.println("Exiting the application");
				exit = true;
				break;

			default:
				System.out.println("Enter Valid Option");
				break;
			}

		}
		scanner.close();
	}

}
