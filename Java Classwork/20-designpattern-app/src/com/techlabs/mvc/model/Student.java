package com.techlabs.mvc.model;

//Model
public class Student {
    String studentName;
    int studentRollNumber;

    public Student(String studentName, int studentRollNumber) {
        this.studentName = studentName;
        this.studentRollNumber = studentRollNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentRollNumber() {
        return studentRollNumber;
    }

    public void setStudentRollNumber(int studentRollNumber) {
        this.studentRollNumber = studentRollNumber;
    }
}
