package com.techlabs.mvc.model;

//Controller
public class StudentController {
    private Student student;
    private StudentView studentView;

    public StudentController(Student student, StudentView studentView) {
        this.student = student;
        this.studentView = studentView;
    }

//    Control Model object
    public void setStudentName(String studentName){
        student.setStudentName(studentName);
    }

    public void setStudentVRollNumber(int rollNumber){
        student.setStudentRollNumber(rollNumber);
    }

//    Control view Object
    public void printStudentDetails(){
        studentView.setStudent(student);
        studentView.viewStudentDetails();
    }
}
