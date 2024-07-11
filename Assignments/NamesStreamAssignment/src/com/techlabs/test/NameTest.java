/*
1.  Read the names from the provided text file (names.txt) and store them in a List of Strings.
2.  Filter the names to include only those that start with a specific letter (e.g., 'A').
3.  Convert all names to uppercase. 
4.  Sort the names alphabetically. 
5.  Remove duplicate names from the list. 
6.  Collect the names into a new list. 
7.  Count the number of names that satisfy a certain condition -   names that does not contain ‘i’
8.  Concatenate all the names into a single string separated by commas.
9.  Filter names that start with 'J', convert them to uppercase, sort them, and then collect them into a list.
 */

package com.techlabs.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class NameTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 1
		System.out.println(
				"\n1-Read the names from the provided text file (names.txt) and store them in a List of Strings");
		String filePath = "C:\\Users\\ACER\\Documents\\MonoJava\\Assignments\\NamesStreamAssignment\\src\\com\\techlabs\\test\\names";
		List<String> nameList = new ArrayList<String>();
		try {
			FileReader nameReader = new FileReader(filePath);
			Scanner fileScanner = new Scanner(nameReader);

			while (fileScanner.hasNextLine()) {
				String name = fileScanner.nextLine();
				nameList.add(name);
			}

			fileScanner.close();
			nameReader.close();
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("All the names in the list\n");
		nameList.stream().forEach((name) -> System.out.println(name));

		// 2
		System.out.println(
				"\n2-Enter the specific latter to check the names that include only those that start with that letter");
		char specificLetter = scanner.next().charAt(0);
		List<String> specificLetterNames = nameList.stream()
				.filter((name) -> Character.toLowerCase(name.charAt(0)) == Character.toLowerCase(specificLetter))
				.collect(Collectors.toList());
		System.out.println("Names starting with : " + specificLetter);
		specificLetterNames.stream().forEach((name) -> System.out.println(name));

		// 3
		System.out.println("\n3-Convert all names to uppercase");
		List<String> uppercaseNames = nameList.stream().map((name) -> name.toUpperCase()).collect(Collectors.toList());
		uppercaseNames.stream().forEach((name) -> System.out.println(name));

		// 4
		System.out.println("\n4-Sort the names alphabetically");
		List<String> sortedNames = nameList.stream().sorted().collect(Collectors.toList());
		sortedNames.stream().forEach((name) -> System.out.println(name));

		// 5 & 6
		System.out.println("\n5 & 6-Remove duplicate names from the list and store into new List");
		Set<String> duplicateNameRemover = new HashSet<String>();
		List<String> cleanList = nameList.stream().filter((name) -> duplicateNameRemover.add(name))
				.collect(Collectors.toList());
		System.out.println("Clean list without duplicates");
		cleanList.stream().forEach((name) -> System.out.println(name));

		// 7
		System.out.println(
				"\n7-Count the number of names that satisfy a certain condition -   names that does not contain ‘i’");
		long countSatisfiedNames = cleanList.stream().filter((name) -> !name.contains("i")).count();
//		cleanList.stream().filter((name) -> !name.contains("i")).forEach((name) -> System.out.println(name));
		System.out.println("Number of names not containing 'i': " + countSatisfiedNames);

		// 8
		System.out.println("\n8-Concatenate all the names into a single string separated by commas.");
		String concatenatedSingleName = cleanList.stream().reduce((name1, name2) -> name1 + "," + name2).orElse("");
		System.out.println("Single concatenated name : " + concatenatedSingleName);

		// 9
		System.out.println(
				"\n9-Filter names that start with 'J', convert them to uppercase, sort them, and then collect them into a list");
		List<String> namesStartingWithJ = cleanList.stream()
				.filter(name -> name.charAt(0) == 'j' || name.charAt(0) == 'J').map((name) -> name.toUpperCase())
				.sorted().collect(Collectors.toList());
		System.out.println("Names starting with 'J' or 'j' ");
		namesStartingWithJ.stream().forEach((name) -> System.out.println(name));

		scanner.close();

	}

}
