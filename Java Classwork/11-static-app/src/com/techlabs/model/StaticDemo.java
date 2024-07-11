package com.techlabs.model;

public class StaticDemo {
	private static int number1;
	private int number2;

	public StaticDemo() {
		number1 = 0;
		number2 = 0;
	}

	public void increament() {
		number1++;
		number2++;
		decreament();
	}

	{
		System.out.println("Non static block inside StaticDemo class not in any method");
	}

	public static void decreament() {
		number1--;
	}

	public void display() {
		System.out.println("Number 1 : " + number1 + "\tNumber 2 : " + number2);
		System.out.println();
	}

	static {
		System.out.println("Static block in StaticDemo class");
	}

}
