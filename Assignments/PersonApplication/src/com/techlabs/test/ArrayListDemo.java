package com.techlabs.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techlabs.model.Person;

public class ArrayListDemo {

	public static void main(String[] args) {

//----------------->Creating and Initializing User-Defined Objects:

		Scanner scanner = new Scanner(System.in);
		List<Person> persons = new ArrayList<Person>();
		Person person = null;

		System.out.println("Enter Number of Persons to add");
		int numberOfPersons = scanner.nextInt();
		scanner.nextLine(); // Consumes a new line

		for (int i = 0; i < numberOfPersons; i++) {
			System.out.println("Enter Name of person");
			String personName = scanner.nextLine();

			System.out.println("Enter Age of Person");
			int personAge = scanner.nextInt();
			scanner.nextLine(); // Consumes a new line

			System.out.println("Enter Person adress");
			String personAddress = scanner.nextLine();

			person = new Person(personName, personAge, personAddress);
			persons.add(person);

		}

//----------------->Manipulating the ArrayList:

		// Print the details of all Person objects in the ArrayList.

		System.out.println(persons);

		// Add a new Person object at the beginning of the ArrayList.
		System.out.println("Add Person object at the beginning of the ArrayList ");
		System.out.println("Enter Name of person");
		String personName = scanner.nextLine();

		System.out.println("Enter Age of Person");
		int personAge = scanner.nextInt();
		scanner.nextLine(); // Consumes a new line

		System.out.println("Enter Person adress");
		String personAddress = scanner.nextLine();

		person = new Person(personName, personAge, personAddress);
		persons.add(0, person);
		System.out.println(persons);

		// Add a new Person object at the end of the ArrayList.
		System.out.println("Add Person object at the end of the ArrayList ");
		System.out.println("Enter Name of person");
		personName = scanner.nextLine();

		System.out.println("Enter Age of Person");
		personAge = scanner.nextInt();
		scanner.nextLine(); // Consumes a new line

		System.out.println("Enter Person adress");
		personAddress = scanner.nextLine();

		person = new Person(personName, personAge, personAddress);
		persons.add(persons.size() - 1, person);
		System.out.println(persons);

		// Insert a Person object at the third position in the ArrayList.
		System.out.println("Add Person object at the 3rd position of the ArrayList ");
		System.out.println("Enter Name of person");
		personName = scanner.nextLine();

		System.out.println("Enter Age of Person");
		personAge = scanner.nextInt();
		scanner.nextLine(); // Consumes a new line

		System.out.println("Enter Person adress");
		personAddress = scanner.nextLine();

		person = new Person(personName, personAge, personAddress);
		persons.add(2, person);
		System.out.println(persons);

//----------------->Accessing Elements:

		// Print the details of the Person object at the fifth position.
		System.out.println("Printing details of the Person object at the fifth position");
		System.out.println(persons.get(4));

		// Print the details of the first and last Person objects in the ArrayList.
		System.out.println("Printing the details of the first and last Person objects in the ArrayList");
		System.out.println(persons.get(0));
		System.out.println(persons.get(persons.size() - 1));

//----------------->Updating Elements:

		// Change the details of the second Person object in the ArrayList.
		System.out.println("Changing the details of the second Person object in the ArrayList");
		System.out.println("second Person object before changing");
		System.out.println(persons.get(1));

		Person person2 = persons.get(1);
		System.out.println("Changing details of second person");
		System.out.println("Enter new Name of person");
		personName = scanner.nextLine();
		person2.setPersonName(personName);

		System.out.println("Enter new Age of Person");
		personAge = scanner.nextInt();
		person2.setPersonAge(personAge);
		scanner.nextLine(); // Consumes a new line

		System.out.println("Enter new address of person");
		personAddress = scanner.nextLine();
		person2.setPersonAddress(personAddress);

		System.out.println("second Person object after changing");
		System.out.println(persons.get(1));

//----------------->Removing Elements:

		// Remove the first Person object from the ArrayList.
		System.out.println("Removing the first Person object from the ArrayList");
		persons.remove(0);
		System.out.println(persons);

		// Remove the Person object at the third position.
		System.out.println("Removing the Person object at the third position");
		persons.remove(2);
		System.out.println(persons);

//----------------->Searching Elements:

		// Check and Print index of a specific Person (choose any criteria) if exists in
		// the ArrayList.
		System.out.println(
				"Checking and printing Index of specific Person (choose any criteria) if exists in the ArrayList.");
		System.out.println("Enter Name of person to search");
		personName = scanner.nextLine();

		System.out.println("Enter Age of Person to search");
		personAge = scanner.nextInt();
		scanner.nextLine(); // Consumes a new line

		System.out.println("Enter adress of Person to search");
		personAddress = scanner.nextLine();

		Person person3 = new Person(personName, personAge, personAddress);
		if (persons.contains(person3)) {
			System.out.println("The Person exists in Array list");
			System.out.println("Index At which specific person is present : " + persons.indexOf(person3));
		} else {
			System.out.println("The Person does not exist in Array list");
		}

//----------------->Traversing the ArrayList:

		// Use a for-loop to traverse and print the details of each Person in the
		// ArrayList.
		System.out.println("Printing details of persons arraylist using for loop");
		for (int i = 0; i < persons.size(); i++) {
			System.out.println(persons.get(i));
		}

		// Use an enhanced for-loop (for-each loop) to traverse and print the details of
		// each Person in the ArrayList.
		System.out.println("Printing details of persons arraylist using enhanced for loop");
		for (Person person4 : persons) {
			System.out.println(person4);
		}

//----------------->Clearing the ArrayList:

		// Clear all elements from the ArrayList.
		// Print the ArrayList to confirm it is empty.
		System.out.println("Clearing arraylist and printing arraylist to confirm it is empty");
		persons.clear();
		System.out.println(persons);

		scanner.close();
	}

}
