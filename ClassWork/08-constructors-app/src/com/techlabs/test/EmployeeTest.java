package com.techlabs.test;

import com.techlabs.model.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee emp1 = new Employee();
		System.out.println("Employee Details");
		System.out.println("Employee Id : " + emp1.getemployeeId());
		System.out.println("Employee name : " + emp1.getemployeeName());
		System.out.println("Employee Salary : " + emp1.getemployeeSalary());
		System.out.println();

		Employee emp2 = new Employee(1234567, "Shekar", 500000);
		System.out.println("Employee Details");
		System.out.println("Employee Id : " + emp2.getemployeeId());
		System.out.println("Employee name : " + emp2.getemployeeName());
		System.out.println("Employee Salary : " + emp2.getemployeeSalary());
		System.out.println();

		Employee emp3 = new Employee(1234567, "Shekar");
		System.out.println("Employee Details");
		System.out.println("Employee Id : " + emp3.getemployeeId());
		System.out.println("Employee name : " + emp3.getemployeeName());
		System.out.println("Employee Salary : " + emp3.getemployeeSalary());
		System.out.println();

	}

}
