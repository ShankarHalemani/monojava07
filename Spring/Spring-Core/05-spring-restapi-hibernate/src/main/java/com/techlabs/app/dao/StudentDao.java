package com.techlabs.app.dao;

import com.techlabs.app.entity.Student;

import java.util.List;

public interface StudentDao {

    List<Student> getAllStudents();

    Student getStudentById(int studentId);

    Student updateStudent(Student student);

    void deleteStudent(Student studentId);
}
