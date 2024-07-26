package com.techlabs.app.service;

import com.techlabs.app.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(int studentId);

    Student updateStudent(Student student);

    void deleteStudent(Student studentId);
}
