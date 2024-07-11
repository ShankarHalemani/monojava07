package com.techlabs.model;

public class Student2 {
	private int rollNumer;
	private String name;
	private int age;
	private String emailId;
	private Course course;

	public Student2(int rollNumer, String name, int age, String emailId, Course course) {
		super();
		this.rollNumer = rollNumer;
		this.name = name;
		this.age = age;
		this.emailId = emailId;
		this.course = course;
	}

	public Student2() {
		super();
	}

	public int getRollNumer() {
		return rollNumer;
	}

	public void setRollNumer(int rollNumer) {
		this.rollNumer = rollNumer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student2 [rollNumer=" + rollNumer + ", name=" + name + ", age=" + age + ", emailId=" + emailId
				+ ", course=" + course + "]";
	}

}
