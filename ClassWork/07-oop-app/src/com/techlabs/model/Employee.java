package com.techlabs.model;

public class Employee {
	private int id;
	private String name;
	private int salary;

	public void setEmpId(int Eid) {
		id = Eid;
	}

	public void setEmpname(String Ename) {
		name = Ename;
	}

	public void setEmpSalary(int Esalary) {
		salary = Esalary;
	}

	public int getEmpId() {
		return id;
	}

	public String getEmpname() {
		return name;
	}

	public int getEmpSalary() {
		return salary;
	}

}
