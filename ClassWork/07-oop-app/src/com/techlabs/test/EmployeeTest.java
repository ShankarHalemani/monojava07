package com.techlabs.test;

import java.util.Scanner;

import com.techlabs.model.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int Eid;
		String Ename;
		int Esalary;

		Employee employee1 = new Employee();

		System.out.println("Enter employee id");
		Eid = scanner.nextInt();
		employee1.setEmpId(Eid);
		System.out.println("Eneter employee name");
		Ename = scanner.next();
		employee1.setEmpname(Ename);
		System.out.println("Eneter employee salary");
		Esalary = scanner.nextInt();
		employee1.setEmpSalary(Esalary);

		System.out.println("Employee-1 deatils");
		System.out.println("Employee id : " + employee1.getEmpId());
		System.out.println("Employee name : " + employee1.getEmpname());
		System.out.println("Employee salary : " + employee1.getEmpSalary());

		System.out.println();

		Employee employee2 = new Employee();

		System.out.println("Enter employee id");
		Eid = scanner.nextInt();
		employee2.setEmpId(Eid);
		System.out.println("Eneter employee name");
		Ename = scanner.next();
		employee2.setEmpname(Ename);
		System.out.println("Eneter employee salary");
		Esalary = scanner.nextInt();
		employee2.setEmpSalary(Esalary);

		System.out.println("Employee-2 deatils");
		System.out.println("Employee id : " + employee2.getEmpId());
		System.out.println("Employee name : " + employee2.getEmpname());
		System.out.println("Employee salary : " + employee2.getEmpSalary());

		scanner.close();
	}

}
