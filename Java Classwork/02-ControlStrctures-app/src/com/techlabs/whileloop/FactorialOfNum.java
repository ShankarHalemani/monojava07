package com.techlabs.whileloop;

import java.util.Scanner;

public class FactorialOfNum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any number");
        int num = scanner.nextInt();

        if (num < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        }
        else {
            int factorial = 1;
            int originalNum = num; 

            while (num > 1) {
                factorial *= num;
                num--;
            }

            System.out.println("Factorial of " + originalNum + " is: " + factorial);
        }

        scanner.close();
    }
}
