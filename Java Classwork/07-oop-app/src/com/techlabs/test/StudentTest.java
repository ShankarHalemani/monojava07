package com.techlabs.test;

import java.util.Scanner;

import com.techlabs.model.Student;

public class StudentTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int rollNum;
		String Sname;
		int Sage;
		Student student1 = new Student();

		System.out.println("Enter student 1 details");
		System.out.println("Enter student rollnumber");
		rollNum = scanner.nextInt();
		student1.setrollNumber(rollNum);
		System.out.println("Eneter student name");
		Sname = scanner.next();
		student1.setName(Sname);
		System.out.println("Eneter student age");
		Sage = scanner.nextInt();
		student1.setAge(Sage);

		System.out.println("Student 1 details");
		System.out.println("Student 1 roll number : " + student1.getrollNumber());
		System.out.println("Student 1 name : " + student1.getName());
		System.out.println("Stduent 1 age : " + student1.getAge());

		System.out.println();

		Student student2 = new Student();

		System.out.println("Enter student 2 details");
		System.out.println("Enter student rollnumber");
		rollNum = scanner.nextInt();
		student2.setrollNumber(rollNum);
		System.out.println("Eneter student name");
		Sname = scanner.next();
		student2.setName(Sname);
		System.out.println("Eneter student age");
		Sage = scanner.nextInt();
		student2.setAge(Sage);

		System.out.println("Student 2 details");
		System.out.println("Student 2 roll number : " + student2.getrollNumber());
		System.out.println("Student 2 name : " + student2.getName());
		System.out.println("Stduent 2 age : " + student2.getAge());
		scanner.close();
	}

}
