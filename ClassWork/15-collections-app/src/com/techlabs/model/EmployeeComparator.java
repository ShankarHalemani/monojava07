package com.techlabs.model;

import java.util.Comparator;

public class EmployeeComparator {

	public static class EmployeesByName implements Comparator<Employee> {
		@Override
		public int compare(Employee employee1, Employee employee2) {

			return employee1.getEmployeeName().compareTo(employee2.getEmployeeName());
		}
	}

	public static class EmployeesBySalary implements Comparator<Employee> {
		@Override
		public int compare(Employee employee1, Employee employee2) {

			return (int)(employee1.getEmployeeSalary() - employee2.getEmployeeSalary());
		}
	}

}
