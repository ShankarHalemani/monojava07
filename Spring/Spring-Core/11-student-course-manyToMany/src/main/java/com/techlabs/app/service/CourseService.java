package com.techlabs.app.service;

import com.techlabs.app.dto.CourseRequestDTO;
import com.techlabs.app.dto.CourseResponseDTO;
import com.techlabs.app.dto.StudentResponseDTO;

import java.util.List;

public interface CourseService {
    List<CourseResponseDTO> getAllCourses();

    CourseResponseDTO getCourseById(int id);

    CourseResponseDTO addNewCourse(CourseRequestDTO course);

    CourseResponseDTO updateCourse(CourseRequestDTO course);

    void deleteCourse(int id);

    void addStudentToCourse(int studentId, int courseId);

    void deleteStudentFromCourse(int studentId, int courseId);

    List<StudentResponseDTO> getStudentsByCourseId(int id);
}
