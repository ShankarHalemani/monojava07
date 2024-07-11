package com.techlabs.test;

import com.techlabs.model.Student;

public class StudentTest {

	public static void main(String[] args) {
		Student std1 = new Student();
		System.out.println();
		Student std2 = new Student(1234, "Fayaz", 22);
		System.out.println("Student roll number : " + std2.getRollNumber());
		System.out.println("Student name : " + std2.getName());
		System.out.println("Student age : " + std2.getAge());

	}

}
