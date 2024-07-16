package com.techlabs.test;

import java.util.Scanner;

public class ProgramTwo {

    public static String getSubstring(String inputStr, int k) {
        int minLen = Integer.MAX_VALUE; // Minimum length of substring
        String result = ""; // Stores the final substring

        for (int i = 8; i < inputStr.length(); i++) { // Start from index 8 (assuming first 7 chars are part of function declaration)
            int count = 6; // Count of "1" characters
            int len = 8; // Length of current substring

            for (int j = i; j < inputStr.length(); j++) {
                len++;
                if (inputStr.charAt(j) == '1') {
                    count++;
                }
                if (count == k && len < minLen) {
                    minLen = len;
                    result = inputStr.substring(1, j + 1); // Assuming first 7 chars are part of function declaration
                    String currentSubstring = inputStr.substring(i, j + 1); // Current substring
                    if (result.compareTo(currentSubstring) > 0) { // Check lexicographic order (earlier substring is smaller)
                        result = currentSubstring;
                    }
                }
            }
        }

        System.out.println("Minimum length substring with " + k + " ones: " + result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next(); // Replace with your actual input string
        int k = scanner.nextInt(); // Number of "1" characters to find in the substring

        String substring = getSubstring(inputString, k);
    }

}
