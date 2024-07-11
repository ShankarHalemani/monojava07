package com.techlabs.test;

import java.util.Scanner;

import com.techlabs.model.CurrentAccount;
import com.techlabs.model.SavingsAccount;

public class AccountTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		long accountNumber;
		String accountHolderName;
		double accountBalance;
		double amount;

		CurrentAccount currentAccount1 = null;
		SavingsAccount savingsAccount1 = null;

		boolean exit = true;
		boolean exitCurrentAccount = true;
		boolean exitSavingsAccount = true;

		while (exit) {
			int optionOfAccount;
			System.out.println();
			System.out.println("Choose");
			System.out.println("1. Current Account");
			System.out.println("2. Savings account");
			System.out.println("3. Exit");
			optionOfAccount = scanner.nextInt();

			switch (optionOfAccount) {
			case 1:
				exitCurrentAccount = true;
				while (exitCurrentAccount) {
					int optionsOfCurrentAccount;
					System.out.println();
					System.out.println("Choose");
					System.out.println("1. Create Account");
					System.out.println("2. Display Account details");
					System.out.println("3. Credit into Account");
					System.out.println("4. Debit from Account");
					System.out.println("5. Exit");
					optionsOfCurrentAccount = scanner.nextInt();
					switch (optionsOfCurrentAccount) {
					case 1:
						System.out.println(" Enter Current Account Details");
						System.out.println();
						System.out.println("Enter account number for Current Account");
						accountNumber = scanner.nextLong();

						System.out.println("Enter account holder name for Current Account");
						accountHolderName = scanner.next();

						System.out.println("Enter account balance for Current Account");
						accountBalance = scanner.nextInt();
						currentAccount1 = new CurrentAccount(accountNumber, accountHolderName, accountBalance);
						break;

					case 2:
						if (currentAccount1 == null) {
							System.out.println("Current account does not exist. Please create an account first.");
							break;
						}
						System.out.println("Account number : " + currentAccount1.getAccountNumber());
						System.out.println("Account holder name : " + currentAccount1.getAccountHolderName());
						System.out.println("Account balance: " + currentAccount1.getAccountBalance());
						break;

					case 3:
						if (currentAccount1 == null) {
							System.out.println("Current account does not exist. Please create an account first.");
							break;
						}
						System.out.println("Enter amount to be deposited to Current Account");
						amount = scanner.nextInt();
						currentAccount1.credit(amount);
						System.out.println("Amount of " + amount + " is credited into your accont");
						break;

					case 4:
						if (currentAccount1 == null) {
							System.out.println("Current account does not exist. Please create an account first.");
							break;
						}
						System.out.println("Enter amount to be withdrawn from Current Account");
						amount = scanner.nextInt();
						currentAccount1.debit(amount);
						break;

					case 5:
						System.out.println("Thank you for visiting, Exiting current account !");
						exitCurrentAccount = false;
						break;

					default:
						System.out.println("Enter valid option");
						break;
					}

				}
				break;

			case 2:
				exitSavingsAccount = true;
				while (exitSavingsAccount) {
					int optionsOfSavingsAccount;
					System.out.println();
					System.out.println("Choose");
					System.out.println("1. Create Account");
					System.out.println("2. Display Account details");
					System.out.println("3. Credit into Account");
					System.out.println("4. Debit from Account");
					System.out.println("5. Exit");
					optionsOfSavingsAccount = scanner.nextInt();
					switch (optionsOfSavingsAccount) {
					case 1:
						System.out.println(" Enter Savings Account Details");
						System.out.println();
						System.out.println("Enter account number for Savings Account");
						accountNumber = scanner.nextLong();

						System.out.println("Enter account holder name for Savings Account");
						accountHolderName = scanner.next();

						System.out.println("Enter account balance for Savings Account");
						accountBalance = scanner.nextInt();
						savingsAccount1 = new SavingsAccount(accountNumber, accountHolderName, accountBalance);
						break;

					case 2:

						if (savingsAccount1 == null) {
							System.out.println("Savings account does not exist. Please create an account first.");
							break;
						}

						System.out.println("Account number : " + savingsAccount1.getAccountNumber());
						System.out.println("Account holder name : " + savingsAccount1.getAccountHolderName());
						System.out.println("Account balance: " + savingsAccount1.getAccountBalance());
						break;

					case 3:
						if (savingsAccount1 == null) {
							System.out.println("Savings account does not exist. Please create an account first.");
							break;
						}

						System.out.println("Enter amount to be deposited to Savings Account");
						amount = scanner.nextInt();
						savingsAccount1.credit(amount);
						System.out.println("Amount of " + amount + " is credited into your accont");
						break;

					case 4:
						if (savingsAccount1 == null) {
							System.out.println("Savings account does not exist. Please create an account first.");
							break;
						}
						System.out.println("Enter amount to be withdrawn from Savings Account");
						amount = scanner.nextInt();
						savingsAccount1.debit(amount);
						break;

					case 5:
						System.out.println("Thank you for visiting, Exiting savings account !");
						exitSavingsAccount = false;
						break;

					default:
						System.out.println("Enter valid option");
						break;
					}
				}
				break;

			case 3:
				System.out.println("Thank you for visiting, keep banking with us !");
				exit = false;
				break;

			default:
				System.out.println("Enter valid option");
				break;
			}
		}

		scanner.close();
	}
}
