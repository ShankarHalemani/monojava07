package com.techlabs.test;

import java.util.Scanner;

import com.techlabs.model.Course;
import com.techlabs.model.Student2;

public class StudentTest2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of students");
		int numOfStudents = scanner.nextInt();

		Student2[] students = new Student2[numOfStudents];

		for (int i = 0; i < students.length; i++) {

			students[i] = new Student2();

			System.out.println("Enter roll number");
			students[i].setRollNumer(scanner.nextInt());

			System.out.println("Enter student name");
			students[i].setName(scanner.next());

			System.out.println("Enter student age");
			students[i].setAge(scanner.nextInt());

			System.out.println("Enter student email id");
			students[i].setEmailId(scanner.next());

			System.out.println(
					"Choose student course: Computerscience -1, ElectricalEngineer -2, Architecture -3, Mechnical -4 ");
			int courseChoose = scanner.nextInt();
			if (courseChoose == 1) {
				students[i].setCourse(Course.Computerscience);
			} else if (courseChoose == 2) {
				students[i].setCourse(Course.ElectricalEngineer);
			} else if (courseChoose == 3) {
				students[i].setCourse(Course.Architecture);
			} else if (courseChoose == 4) {
				students[i].setCourse(Course.Mechnical);
			}

		}

		for (Student2 student : students) {
			System.out.println(student);
			System.out.println();
		}

		scanner.close();

	}

}
