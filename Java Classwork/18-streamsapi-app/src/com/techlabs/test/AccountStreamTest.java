/*
 * Create list of Account(accno, name, balance)
a. Show Account details of account with minimum Balance
b. Show Account details of account with maximum Balance
c. Show names greater than 6 characters
d. find total of balance of all accounts
 */

package com.techlabs.test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.techlabs.model.Account;

public class AccountStreamTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		long accountNumber;
		String accountHolderName;
		int accountBalance;
		int numberOfAccounts;

		List<Account> accounts = new ArrayList<>();

		System.out.println("Enter number of accounts to be created");
		numberOfAccounts = scanner.nextInt();

		for (int i = 0; i < numberOfAccounts; i++) {
			System.out.println();

			System.out.println("Enter Account Number");
			accountNumber = scanner.nextLong();

			System.out.println("Enter Account Holder Name");
			accountHolderName = scanner.next();

			System.out.println("Enter Account Balance");
			accountBalance = scanner.nextInt();

			accounts.add(new Account(accountNumber, accountHolderName, accountBalance));
		}

		// 1
		Account accountWithMinBalance = accounts.stream().min(
				(account1, account2) -> Integer.compare(account1.getAccountBalance(), account2.getAccountBalance()))
				.orElseThrow(NoSuchElementException::new);
		System.out.println("\nAccount with minimum balance : " + accountWithMinBalance);

		// 2
		Account accountWithMaxBalance = accounts.stream().max(
				(account1, account2) -> Integer.compare(account1.getAccountBalance(), account2.getAccountBalance()))
				.orElseThrow(NoSuchElementException::new);
		System.out.println("\nAccount with maximum balance : " + accountWithMaxBalance);

		// 3
		System.out.println("\nNames greater than 6 characters");
		List<Account> namesGreaterThan6 = accounts.stream()
				.filter((account) -> account.getAccountHolderName().length() > 6).collect(Collectors.toList());
		namesGreaterThan6.forEach((account) -> System.out.println(account.getAccountHolderName()));

		// 4
		int totalAccountBalance = accounts.stream().reduce(0, (sum, account) -> sum + account.getAccountBalance(),
				Integer::sum);
		System.out.println("\nTotal of balance of all accounts : " + totalAccountBalance);

		scanner.close();
	}

}
