package com.techlabs.app.service;

import com.techlabs.app.dto.StudentRequestDTO;
import com.techlabs.app.dto.StudentResponseDTO;
import com.techlabs.app.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentResponseDTO> getAllStudents();

    StudentResponseDTO getStudentById(int id);

    StudentResponseDTO addNewStudent(StudentRequestDTO student);

    StudentResponseDTO updateStudent(StudentRequestDTO student);

    void deleteStudentById(int id);
}
