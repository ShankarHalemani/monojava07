package com.techlabs.app.service;

import com.techlabs.app.dto.CourseRequestDTO;
import com.techlabs.app.dto.CourseResponseDTO;
import com.techlabs.app.dto.StudentResponseDTO;
import com.techlabs.app.entity.Course;
import com.techlabs.app.entity.Student;
import com.techlabs.app.exception.CourseNotFoundException;
import com.techlabs.app.exception.StudentNotFoundException;
import com.techlabs.app.mapper.Mapper;
import com.techlabs.app.repository.CourseRepository;
import com.techlabs.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private Mapper mapper;

    public List<CourseResponseDTO> getResponseList(List<Course> courses) {
        List<CourseResponseDTO> courseResponseList = new ArrayList<>();
        for (Course course : courses) {
            courseResponseList.add(mapper.courseEntityToResponse(course));
        }
        return courseResponseList;
    }

    public List<StudentResponseDTO> getStudentResponseList(List<Student> studentList) {
        List<StudentResponseDTO> studentResponseList = new ArrayList<>();
        for (Student student : studentList) {
            studentResponseList.add(mapper.studentEntityToResponse(student));
        }
        return studentResponseList;
    }

    @Override
    public List<CourseResponseDTO> getAllCourses() {
        List<Course> courseList = courseRepository.findAll();
        return getResponseList(courseList);
    }

    @Override
    public CourseResponseDTO getCourseById(int id) {
        Course course = courseRepository.findById(id).orElseThrow(() ->
                new CourseNotFoundException("Course with ID : " + id + " not found"));

        return mapper.courseEntityToResponse(course);
    }

    @Override
    public CourseResponseDTO addNewCourse(CourseRequestDTO course) {
        Course tempCourse = mapper.courseRequestToEntity(course);
        Course newCourse = courseRepository.save(tempCourse);
        return mapper.courseEntityToResponse(newCourse);
    }

    @Override
    public CourseResponseDTO updateCourse(CourseRequestDTO course) {
        courseRepository.findById(course.getId()).orElseThrow(() ->
                new CourseNotFoundException("Course with ID : " + course.getId() + " not found"));
        Course tempCourse = mapper.courseRequestToEntity(course);
        Course updateCourse = courseRepository.save(tempCourse);
        return mapper.courseEntityToResponse(updateCourse);
    }

    @Override
    public void deleteCourse(int id) {
        courseRepository.findById(id).ifPresent(course ->
                courseRepository.delete(course));
    }

    @Override
    public void addStudentToCourse(int studentId, int courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() ->
                new StudentNotFoundException("Student with ID : " + studentId + " not found"));
        Course course = courseRepository.findById(courseId).orElseThrow(() ->
                new CourseNotFoundException("Course with ID : " + courseId + " not found"));
        student.getCourses().add(course);
        studentRepository.save(student);
    }

    @Override
    public void deleteStudentFromCourse(int studentId, int courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() ->
                new StudentNotFoundException("Student with ID : " + studentId + " not found"));
        Course course = courseRepository.findById(courseId).orElseThrow(() ->
                new CourseNotFoundException("Course with ID : " + courseId + " not found"));
        student.getCourses().remove(course);
        studentRepository.save(student);
    }

    @Override
    public List<StudentResponseDTO> getStudentsByCourseId(int id) {
        Course course = courseRepository.findById(id).orElseThrow(() ->
                new CourseNotFoundException("Course with ID : " + id + " not found"));

        List<Student> studentList = new ArrayList<>(course.getStudents());
        return getStudentResponseList(studentList);
    }


}
