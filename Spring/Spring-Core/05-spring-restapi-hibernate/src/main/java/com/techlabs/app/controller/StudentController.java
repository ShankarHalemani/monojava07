package com.techlabs.app.controller;

import com.techlabs.app.dao.StudentDao;
import com.techlabs.app.entity.Student;
import com.techlabs.app.exception.StudentErrorResponse;
import com.techlabs.app.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;


@RestController
public class StudentController {
    private StudentDao studentDao;

    public StudentController(StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> studentList = studentDao.getAllStudents();
        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(name = "id") int studentId) {
        Student student = studentDao.getStudentById(studentId);
        if (student==null){
            throw new StudentNotFoundException("Student with id : "+studentId+" is not found");
        }
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        student.setStudentId(0);
        Student student1 = studentDao.updateStudent(student);
        return new ResponseEntity<>(student1,HttpStatus.CREATED);
    }

    @PutMapping("/students")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student tempStudent = studentDao.getStudentById(student.getStudentId());
        if (tempStudent == null) {
            throw new RuntimeException("Student with id : "+student.getStudentId()+" is not found !!!!!!!!!!!!!!");
        }
        Student student1 = studentDao.updateStudent(student);
        return new ResponseEntity<>(student1,HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable(name = "id") int studentId) {

        Student student = studentDao.getStudentById(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student with id : "+studentId+" is not found");
        }
        studentDao.deleteStudent(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
