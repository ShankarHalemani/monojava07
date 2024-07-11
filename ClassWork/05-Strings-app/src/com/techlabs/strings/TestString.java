package com.techlabs.strings;

public class TestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string1 = "ABC";

		System.out.println(string1.hashCode());
		System.out.println(string1);

		string1 = string1 + "XYZ";

		System.out.println(string1.hashCode());
		System.out.println(string1);
	}

}
