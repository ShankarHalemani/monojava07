package com.techlabs.model;

public class Employee {
	private int employeeID;
	private String employeeName;
	private int employeeSalary;

	public Employee(int employeeID, String employeeName, int employeeSalary) {

		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	@Override
	public String toString() {
		return "\nEmployee [employeeID=" + employeeID + ", employeeName=" + employeeName + ", employeeSalary="
				+ employeeSalary + "]";
	}

}
