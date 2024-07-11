package com.techlabs.strings;

public class TestString2 {

	private static Object object;

	public static void main(String[] args) {
		String firstName = new String("Shankar");
		StringBuffer middleName = new StringBuffer("Shiva");
		StringBuilder lastName = new StringBuilder("Hale");

		concat1(firstName);
		System.out.println(firstName);
		concat2(middleName);
		System.out.println(middleName);
		concat3(lastName);
		System.out.println(lastName);

	}

	public static void concat1(String firstName) {
		firstName += "ling";
	}

	public static void concat2(StringBuffer middleName) {
		middleName = middleName.append("nand");
	}

	public static void concat3(StringBuilder lastName) {
		lastName = lastName.append("mani");
	}

}
