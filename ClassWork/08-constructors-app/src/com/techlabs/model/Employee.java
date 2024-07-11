package com.techlabs.model;

public class Employee {
	private int employeeId;
	private String employeeName;
	private int employeeSalary;

	public Employee() {
		employeeId = 3;
		employeeName = "Satish";
		employeeSalary = 10000;
	}

	public Employee(int employeeId, String employeeName, int employeeSalary) {
		this(); // it is going to above constructor and setting value but
		this.employeeId = employeeId; // then it overwritten by these statements
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;

	}

	public Employee(int employeeId, String employeeName) {
		this(employeeId, employeeName, 300000);

	}

	public void setemployeeId(int EId) {
		employeeId = EId;
	}

	public int getemployeeId() {
		return employeeId;
	}

	public void setemployeeName(String EName) {
		employeeName = EName;
	}

	public String getemployeeName() {
		return employeeName;
	}

	public void setemployeeSalary(int ESalary) {
		employeeSalary = ESalary;
	}

	public int getemployeeSalary() {
		return employeeSalary;
	}
}
