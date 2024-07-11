/*

Question:
Create a function isSubstring(str1,str2) that returns true when str2 is a substring of str1 and returns false otherwise.
             

Difficulty: Medium

Example:
  Ex.  isSubstring("madam","mam") => false

       isSubstring("madam","dam") => true

       isSubstring("madam","mad") => true

       isSubstring("madam","madam") => true

Constraints:
Function should not exceed time complexity O(n)
 
*/

package com.techlabs.arrays;

import java.util.Scanner;

public class SubStringProblem {

	// Function to compute the LPS (Longest Prefix Suffix) array for the pattern
	private static int[] computeLPS(String pattern) {
		int m = pattern.length();
		int[] lps = new int[m];
		int len = 0;
		int i = 1;

		while (i < m) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}

	// Function to check if str2 is a substring of str1 using KMP algorithm
	public static boolean isSubstring(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();

		// Compute LPS array for the pattern (str2)
		int[] lps = computeLPS(str2);

		int i = 0; // Index for str1
		int j = 0; // Index for str2

		while (i < n) {
			if (str1.charAt(i) == str2.charAt(j)) {
				i++;
				j++;
			}
			if (j == m) {
				return true; // Match found
			}
			if (i < n && str1.charAt(i) != str2.charAt(j)) {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
		return false; // No match found
	}

	// Main method to test the isSubstring function
	public static void main(String[] args) {
		// Test cases
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter string 1");
		String string1 = scanner.next();

		System.out.println("Enter string 2");
		String string2 = scanner.next();

		System.out.println(isSubstring(string1, string2));

		scanner.close();

	}
}
