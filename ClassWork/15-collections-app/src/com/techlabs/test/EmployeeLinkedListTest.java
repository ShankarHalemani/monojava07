package com.techlabs.test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

import com.techlabs.model.Employee;
import com.techlabs.model.EmployeeComparator;

public class EmployeeLinkedListTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		LinkedList<Employee> employees = new LinkedList<Employee>();

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

//		System.out.println("Normal For");
//		for (int i = 0; i < employees.size(); i++) {
//			System.out.println(employees.get(i));
//		}
//
//		System.out.println("For without index");
//		for (Employee employee : employees) {
//			System.out.println(employee);
//		}
//
//		System.out.println("Iterator");
//		Iterator employeeIterator = employees.iterator();
//		while (employeeIterator.hasNext()) {
//			System.out.println(employeeIterator.next());
//		}
//
//		ListIterator empListIterator = employees.listIterator();
//		System.out.println("List iterator forward");
//		while (empListIterator.hasNext()) {
//			System.out.println(empListIterator.next());
//		}
//
//		System.out.println("List iterator Backward");
//		while (empListIterator.hasPrevious()) {
//			System.out.println(empListIterator.previous());
//		}
//
//		Employee employee1 = new Employee(1234, "XYZ", 10000);
//		employees.offerFirst(employee1);
//		System.out.println("Using To string");
//		System.out.println(employees);
//		scanner.close();

//		Collections.sort(employees, new EmployeesByName());
//
//		System.out.println(employees);
//
//		Collections.sort(employees, new EmployeesBySalary());
//
//		System.out.println(employees);

		Collections.sort(employees, new EmployeeComparator.EmployeesByName());

		System.out.println(employees);

		Collections.sort(employees, new EmployeeComparator.EmployeesBySalary());

		System.out.println(employees);

	}

}
