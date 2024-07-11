package com.techlabs.model;

public class Student {
	private int rollNumber;
	private String name;
	private int age;

	public Student() {
		System.out.println("Student details ");
	}

	public Student(int rollNum, String sname, int sage) {
		rollNumber = rollNum;
		name = sname;
		age = sage;
	}

	public void setRollNumber(int rollNum) {
		rollNumber = rollNum;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setName(String sname) {
		name = sname;
	}

	public String getName() {
		return name;
	}

	public void setAge(int sage) {
		age = sage;
	}

	public int getAge() {
		return age;
	}
}
