package com.techlabs.creational.factory.test;

import com.techlabs.creational.factory.model.AccountFactory;
import com.techlabs.creational.factory.model.IAccount;
import com.techlabs.creational.factory.model.SavingsAccount;
import com.techlabs.creational.factory.model.CurrentAccount;

import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        IAccount account=null;
        int choose;
        int accounNumber;
        String accountName;
        int accountBalance;
        int overdraftLimit;

        boolean exit=false;

        while (!exit){
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. View Savings Account");
            System.out.println("4. View Current Account");
            System.out.println("5. Perform account related operations");
            System.out.println("6. Exit");
            choose=scanner.nextInt();

            switch (choose){
                case 1 :
                    System.out.println("Enter account number");
                    accounNumber = scanner.nextInt();

                    System.out.println("Enter account holder name");
                    accountName = scanner.next();

                    System.out.println("Enter account balance");
                    accountBalance = scanner.nextInt();

                    account= AccountFactory.getAccount(accounNumber,accountName,accountBalance);
                    System.out.println("Account created");
                    break;

                case 2:
                    System.out.println("Enter account number");
                    accounNumber = scanner.nextInt();

                    System.out.println("Enter account balance");
                    accountBalance = scanner.nextInt();

                    System.out.println("Enter Account overdraft limit");
                    overdraftLimit = scanner.nextInt();

                    account= AccountFactory.getAccount(accounNumber,accountBalance,overdraftLimit);
                    System.out.println("Account created");
                    break;

                case 3:
                    if(account instanceof SavingsAccount){
                        account.displayAccountDetails();
                        break;
                    }

                    System.out.println("Create Savings Account first");
                    break;

                case 4:
                    if(account instanceof CurrentAccount){
                        account.displayAccountDetails();
                        break;
                    }
                    System.out.println("Create Current Account first");
                    break;

                case 5:
                    if(account==null){
                        System.out.println("Create Account first");
                        break;
                    }
                    int accountType;
                    System.out.println("Choose account type to perform operations");
                    System.out.println("1. Savings account");
                    System.out.println("2. Current Account");
                    accountType=scanner.nextInt();
                    switch (accountType){
                        case 1:
                            if (account instanceof SavingsAccount) {
                                System.out.println("Performing operations on Savings Account");
                                performAccountOperations(scanner, account);
                            }
                            break;

                        case 2:

                            if (account instanceof CurrentAccount) {
                                System.out.println("Performing operations on Current Account");
                                performAccountOperations(scanner, account);
                            }
                            break;

                        default:
                            System.out.println("Choose Valid Option");
                            System.out.println("Going back to Main menu");
                            break;
                    }
                    break;

                case 6:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please choose again.");

            }
        }

    }

    private static void performAccountOperations(Scanner scanner, IAccount account) {
        int operation;
        boolean backToMenu = false;

        while (!backToMenu) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Back to Main Menu");
            operation = scanner.nextInt();

            switch (operation) {
                case 1:
                    System.out.println("Enter amount to deposit:");
                    int depositAmount = scanner.nextInt();
                    account.credit(depositAmount);
                    System.out.println("Deposited: " + depositAmount);
                    break;

                case 2:
                    System.out.println("Enter amount to withdraw:");
                    int withdrawAmount = scanner.nextInt();
                    account.debit(withdrawAmount);
                    break;

                case 3:
                    backToMenu = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}
