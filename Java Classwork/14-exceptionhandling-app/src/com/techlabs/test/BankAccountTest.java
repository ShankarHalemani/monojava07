package com.techlabs.test;

import com.techlabs.exceptions.InsufficientFundsException;
import com.techlabs.exceptions.NegativeAmountException;
import com.techlabs.model.BankAccount;

public class BankAccountTest {

	public static void main(String[] args) {
		try {
			BankAccount bankAccount1 = new BankAccount(1234567, 20000);
			BankAccount bankAccount2 = new BankAccount(2345678, 30000);

			bankAccount1.withdrawal(3000);
			bankAccount2.deposite(-2000);

		}

		catch (NegativeAmountException e) {
			System.out.println(e.getMessage());
		}

		catch (InsufficientFundsException e) {
			System.out.println(e.getMessage());
		}
	}

}
