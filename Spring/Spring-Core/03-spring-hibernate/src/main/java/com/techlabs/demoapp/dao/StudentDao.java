package com.techlabs.demoapp.dao;

import com.techlabs.demoapp.entity.Student;

import java.util.List;

public interface StudentDao {
    public void save(Student student);

    List<Student> getAllStudents();

    Student getStudentById(int i);


    List<Student> getStudentByFirstName(String name);

    List<Student> getStudentByFirstNameAndLastName(String firstName, String lastName);

    void updateStudent(Student student);

    void deleteStudent(int id);

    void updateStudentWithoutMerge(Student student);

    void deleteStudentIdLessThan(int i);
}
