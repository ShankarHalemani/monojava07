package com.techlabs.model;

import java.util.ArrayList;
import java.util.List;

public class StudentDataUtil {

	public static List<Student> getStudents() {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("Shankar", "Halemani", "xyz@123gmail.com"));
		students.add(new Student("Soumya", "K", "abc@123gmail.com"));
		students.add(new Student("Soujanya", "J", "mon@123gmail.com"));
		students.add(new Student("Radha", "U", "pqr@123gmail.com"));
		students.add(new Student("Zoro", "Roronova", "qwe@123gmail.com"));

		return students;
	}

}
