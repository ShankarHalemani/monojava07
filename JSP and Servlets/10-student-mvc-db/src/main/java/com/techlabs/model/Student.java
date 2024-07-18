package com.techlabs.model;

import java.util.Date;

public class Student {
	private int studentId;
	private String firstName;
	private String lastName;
	private String emailId;

	private Gender genderType;

	private Date date;

	public Student(int studentId, String firstName, String lastName, String emailId, Date date, Gender genderType) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.date = date;
		this.genderType = genderType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Gender getGenderType() {
		return genderType;
	}

	public void setGenderType(Gender genderType) {
		this.genderType = genderType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", genderType=" + genderType + ", date=" + date + "]";
	}

}
