package com.techlabs.forloop;

public class RightAnglePrimeTriangle {

    public static void main(String[] args) {
        int[] a = new int[50]; 

        int k = 0; 
        for (int i = 2; i <= 75; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                a[k] = i; 
                k++;
            }
        }

        
        int count = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(a[count] + " ");
                count++;
            }
            System.out.println();
        }
    }
}
