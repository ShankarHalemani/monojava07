package com.techlabs.app.service;

import com.techlabs.app.dto.StudentRequestDTO;
import com.techlabs.app.dto.StudentResponseDTO;
import com.techlabs.app.entity.Course;
import com.techlabs.app.entity.Student;
import com.techlabs.app.exception.StudentNotFoundException;
import com.techlabs.app.mapper.Mapper;
import com.techlabs.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private Mapper mapper;

    public List<StudentResponseDTO> getResponseList(List<Student> studentList) {
        List<StudentResponseDTO> studentResponseList = new ArrayList<>();
        for (Student student : studentList) {
            studentResponseList.add(mapper.studentEntityToResponse(student));
        }
        return studentResponseList;
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        return getResponseList(studentList);
    }

    @Override
    public StudentResponseDTO getStudentById(int id) {
        Student student = studentRepository.findById(id).orElseThrow(() ->
                new StudentNotFoundException("Student with ID : " + id + " not found"));

        return mapper.studentEntityToResponse(student);
    }

    @Override
    public StudentResponseDTO addNewStudent(StudentRequestDTO student) {
        Student tempStudent = mapper.studentRequestToEntity(student);
        Student newStudent = studentRepository.save(tempStudent);
        return mapper.studentEntityToResponse(newStudent);
    }

    @Override
    public StudentResponseDTO updateStudent(StudentRequestDTO student) {
        Student tempStudent = studentRepository.findById(student.getId()).orElseThrow(() ->
                new StudentNotFoundException("Student with ID : " + student.getId() + " not found"));

        return mapper.studentEntityToResponse(tempStudent);
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.findById(id).ifPresent(student ->
                studentRepository.delete(student));
    }
}
