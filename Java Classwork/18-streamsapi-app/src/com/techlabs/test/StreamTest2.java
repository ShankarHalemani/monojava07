package com.techlabs.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StreamTest2 {

	public static void main(String[] args) {
//		String[] names = { "Jayesh", "Nimesh", "Mark", "Mahesh", "Ramesh" };

		List<String> names = Arrays.asList("Jayesh", "Nimesh", "Mark", "Mahesh", "Ramesh");

		System.out.println("First 3 Names in sorted Order");
		names.stream().sorted().limit(3).forEach((x) -> System.out.println(x));
		System.out.println();

		System.out.println("First 3 students sorted in ascending order if it contains 'a' ");
		names.stream().filter((x) -> x.contains("a")).sorted().limit(3).forEach((x) -> System.out.println(x));
		System.out.println();

		System.out.println("Students in descnding order");
		names.stream().sorted(Collections.reverseOrder()).forEach((x) -> System.out.println(x));
		System.out.println();

		System.out.println("First 3 characters of all names:");
		names.stream().map((x) -> x.substring(0, 3)).forEach((x) -> System.out.println(x));
		System.out.println();

		System.out.println("Names of the students that contains less than or equal to 4 characters");
		names.stream().filter((x) -> x.length() <= 4).forEach((x) -> System.out.println(x));
		System.out.println();

	}

}
