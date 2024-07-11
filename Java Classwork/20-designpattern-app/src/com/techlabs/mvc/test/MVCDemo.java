package com.techlabs.mvc.test;

import com.techlabs.mvc.model.Student;
import com.techlabs.mvc.model.StudentController;
import com.techlabs.mvc.model.StudentView;

import java.util.Scanner;

public class MVCDemo {
    public static void main(String[] args) {
        Student model = retrieveModelFromDatabase();
        StudentView view = new StudentView(model);
        StudentController controller = new StudentController(model,view);

        controller.printStudentDetails();

        controller.setStudentName("Fayaz K");
        controller.setStudentVRollNumber(2345);

        System.out.println("\nUpdated Details : ");
        controller.printStudentDetails();


    }

    private static Student retrieveModelFromDatabase() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Student Roll Number");
        int studentRollNumber = scanner.nextInt();
        scanner.nextLine();//consume new line

        System.out.println("Enter Student Name");
        String studentName = scanner.nextLine();

        Student student = new Student(studentName,studentRollNumber);
        return student;
    }
}
