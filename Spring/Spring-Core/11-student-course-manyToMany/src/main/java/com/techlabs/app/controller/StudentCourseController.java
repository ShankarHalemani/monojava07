package com.techlabs.app.controller;

import com.techlabs.app.dto.CourseRequestDTO;
import com.techlabs.app.dto.CourseResponseDTO;
import com.techlabs.app.dto.StudentRequestDTO;
import com.techlabs.app.dto.StudentResponseDTO;
import com.techlabs.app.service.CourseService;
import com.techlabs.app.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentCourseController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Operation(summary = "Get All Students")
    @GetMapping("/students")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {
        List<StudentResponseDTO> responseDTOList = studentService.getAllStudents();
        return new ResponseEntity<>(responseDTOList, HttpStatus.OK);
    }

    @Operation(summary = "Get student by ID")
    @GetMapping("/students/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@Valid @PathVariable(name = "id") int id) {
        StudentResponseDTO responseDTO = studentService.getStudentById(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);
    }

    @Operation(summary = "Add new Student")
    @PostMapping("/students")
    public ResponseEntity<StudentResponseDTO> addNewStudent(@Valid @RequestBody StudentRequestDTO student) {
        student.setId(0);
        StudentResponseDTO studentResponseDTO = studentService.addNewStudent(student);
        return new ResponseEntity<>(studentResponseDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Update Student")
    @PutMapping("/students")
    public ResponseEntity<StudentResponseDTO> updateStudent(@Valid @RequestBody StudentRequestDTO student) {
        StudentResponseDTO studentResponseDTO = studentService.updateStudent(student);
        return new ResponseEntity<>(studentResponseDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Delete Student By ID")
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Object> deleteStudent(@Valid @PathVariable(name = "id") int id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Student with ID : " + id + " deleted successfully");
    }

    @Operation(summary = "Get All courses")
    @GetMapping("/courses")
    public ResponseEntity<List<CourseResponseDTO>> getAllCourses() {
        List<CourseResponseDTO> courseResponseDTOS = courseService.getAllCourses();
        return new ResponseEntity<>(courseResponseDTOS, HttpStatus.OK);
    }

    @Operation(summary = "Get Course By ID")
    @GetMapping("/courses/{id}")
    public ResponseEntity<CourseResponseDTO> getCourseById(@Valid @PathVariable(name = "id") int id) {
        CourseResponseDTO courseResponseDTO = courseService.getCourseById(id);
        return new ResponseEntity<>(courseResponseDTO, HttpStatus.FOUND);
    }

    @Operation(summary = "Add new Course")
    @PostMapping("/courses")
    public ResponseEntity<CourseResponseDTO> addNewCourse(@Valid @RequestBody CourseRequestDTO course) {
        course.setId(0);
        CourseResponseDTO courseResponseDTO = courseService.addNewCourse(course);
        return new ResponseEntity<>(courseResponseDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Update Course")
    @PutMapping("/courses")
    public ResponseEntity<CourseResponseDTO> updateCourse(@Valid @RequestBody CourseRequestDTO course) {
        CourseResponseDTO courseResponseDTO = courseService.updateCourse(course);
        return new ResponseEntity<>(courseResponseDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Delete course by ID")
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Object> deleteCourse(@Valid @PathVariable(name = "id") int id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(HttpStatus.OK).body("Course with ID : " + id + " deleted successfully");
    }

    @Operation(summary = "Add Student to a Course")
    @PostMapping("/students/{studentId}/courses/{courseId}")
    public ResponseEntity<Object> addStudentToCourse(@Valid @PathVariable(name = "studentId") int studentId,
                                                     @Valid @PathVariable(name = "courseId") int courseId) {
        courseService.addStudentToCourse(studentId, courseId);
        return ResponseEntity.status(HttpStatus.OK).body("Student with ID : " + studentId +
                " assigned to course with ID : " + courseId + " successfully");

    }

    @Operation(summary = "Remove Student from a Course")
    @DeleteMapping("/students/{studentId}/courses/{courseId}")
    public ResponseEntity<Object> deleteStudentFromCourse(@Valid @PathVariable(name = "studentId") int studentId,
                                                          @Valid @PathVariable(name = "courseId") int courseId) {
        courseService.deleteStudentFromCourse(studentId, courseId);
        return ResponseEntity.status(HttpStatus.OK).body("Student with ID : " + studentId +
                " removed from course with ID : " + courseId + " successfully");

    }

    @Operation(summary = "Get all students for particular Course")
    @GetMapping("/students/courses/{id}")
    public ResponseEntity<List<StudentResponseDTO>> getStudentsByCourseId(@Valid @PathVariable(name = "id") int id) {
        List<StudentResponseDTO> studentResponseDTOS = courseService.getStudentsByCourseId(id);
        return new ResponseEntity<>(studentResponseDTOS, HttpStatus.FOUND);
    }
}
