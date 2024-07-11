package com.techlabs.mvc.model;

//View
public class StudentView {
    private Student student;

    public StudentView(Student student) {
        this.student=student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void viewStudentDetails(){
        System.out.println();
        System.out.println("Student Roll Number : "+student.getStudentRollNumber());
        System.out.println("Student Name : "+student.getStudentName());
    }
}
