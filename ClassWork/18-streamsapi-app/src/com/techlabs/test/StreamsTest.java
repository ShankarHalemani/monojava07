package com.techlabs.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsTest {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 25, 35, 40, 55);

		System.out.println("All numbers");
		numbers.stream().forEach((x) -> System.out.println(x + 5));

		System.out.println("All odd numbers");
		numbers.stream().filter((x) -> x % 2 != 0).forEach((x) -> System.out.println(x));

		List<Integer> evenNumbers = numbers.stream().filter((x) -> x % 2 != 0).collect(Collectors.toList());

		System.out.println("All even numbers");
		evenNumbers.stream().forEach((x) -> System.out.println(x));

		int addition = numbers.stream().reduce(0, (sum, x) -> sum + x);
		System.out.println("Sum of elements : " + addition);

		System.out.println("Multipliers of Five");
		List<Integer> multipliersOfFive = numbers.stream().map((x) -> x * 5).collect(Collectors.toList());
		multipliersOfFive.stream().forEach((x) -> System.out.println(x));

		System.out.println("Sorted elements");
		numbers.stream().sorted().limit(3).forEach((x) -> System.out.println(x));

	}

}
