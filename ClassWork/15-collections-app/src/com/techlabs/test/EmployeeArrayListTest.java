package com.techlabs.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.techlabs.model.Employee;

public class EmployeeArrayListTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Employee> employees = new ArrayList<Employee>();

		System.out.println("Enter number employees to be added");
		int numberOfEmployees = scanner.nextInt();

		for (int i = 0; i < numberOfEmployees; i++) {
			System.out.println("Enter New Employee");
			System.out.println("Enter Employee ID");
			int employeeID = scanner.nextInt();

			System.out.println("Enter employee name");
			String employeeName = scanner.next();

			System.out.println("Enter Employee salary");
			int employeeSalary = scanner.nextInt();

			Employee employee = new Employee(employeeID, employeeName, employeeSalary);
			employees.add(employee);
		}

		System.out.println("Normal For");
		for (int i = 0; i < employees.size(); i++) {
			System.out.println(employees.get(i));
		}

		System.out.println("For without index");
		for (Employee employee : employees) {
			System.out.println(employee);
		}

		System.out.println("Iterator");
		Iterator employeeIterator = employees.iterator();
		while (employeeIterator.hasNext()) {
			System.out.println(employeeIterator.next());
		}

		ListIterator empListIterator = employees.listIterator();
		System.out.println("List iterator forward");
		while (empListIterator.hasNext()) {
			System.out.println(empListIterator.next());
		}

		System.out.println("List iterator Backward");
		while (empListIterator.hasPrevious()) {
			System.out.println(empListIterator.previous());
		}

		System.out.println("Using To string");
		System.out.println(employees);
		scanner.close();
	}

}
