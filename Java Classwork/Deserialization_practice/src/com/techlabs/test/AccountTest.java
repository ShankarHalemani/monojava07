package com.techlabs.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.techlabs.model.CurrentAccount;
import com.techlabs.model.SavingsAccount;

public class AccountTest {
	public static void main(String[] args) {

		CurrentAccount currentAccount1 = null;
		SavingsAccount savingsAccount1 = null;

//		Deserialization
		try {
			FileInputStream fileInputStream = new FileInputStream(
					"C:\\Users\\ACER\\Documents\\MonoJava\\Serialization_practice\\serializedFile.ser");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			currentAccount1 = (CurrentAccount) objectInputStream.readObject();
			savingsAccount1 = (SavingsAccount) objectInputStream.readObject();
			objectInputStream.close();
			fileInputStream.close();
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Test CurrentAccount
		if (currentAccount1 != null) {
			System.out.println("Current Account Details");
			System.out.println();
			System.out.println("Account number : " + currentAccount1.getAccountNumber());
			System.out.println("Account holder name : " + currentAccount1.getAccountHolderName());
			System.out.println("Account balance: " + currentAccount1.getAccountBalance());
			System.out.println("\n");
		}

		// Test SavingsAccount
		if (savingsAccount1 != null) {
			System.out.println("Savings Account Details");
			System.out.println();
			System.out.println("Account number : " + savingsAccount1.getAccountNumber());
			System.out.println("Account holder name : " + savingsAccount1.getAccountHolderName());
			System.out.println("Account balance: " + savingsAccount1.getAccountBalance());

		}
	}
}
