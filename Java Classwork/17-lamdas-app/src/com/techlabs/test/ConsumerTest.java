package com.techlabs.test;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerTest {

	public static void main(String[] args) {
		Consumer<Integer> consumer = (number) -> {
			System.out.println("The given number is :" + number + "\n");
		};

		consumer.accept(20);

		Consumer<Integer> consumer2 = (number) -> {
			int factorial = 1;
			int original = number;
			while (number > 0) {
				factorial *= number;
				number--;
			}
			System.out.println("Factorial of " + original + " : " + factorial);
			System.out.println();
		};

		consumer2.accept(5);

		BiConsumer<Integer, Integer> adder = (number1, number2) -> {
			System.out.println("Addition of " + number1 + " and " + number2 + " : " + (number1 + number2));
			System.out.println();
		};

		adder.accept(20, 30);

		BiConsumer<Integer, Integer> swapper = (number1, number2) -> {

			System.out.println("Before swapping : Number 1 : " + number1 + " & Number 2 : " + number2);
			System.out.println();

			number1 = number1 + number2;
			number2 = number1 - number2;
			number1 = number1 - number2;

			System.out.println("After swapping : Number 1 : " + number1 + " & Number 2 : " + number2);
			System.out.println();

		};
		swapper.accept(10, 30);

	}

}
