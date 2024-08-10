package com.techlabs.app.mapper;

import com.techlabs.app.dto.CourseRequestDTO;
import com.techlabs.app.dto.CourseResponseDTO;
import com.techlabs.app.dto.StudentRequestDTO;
import com.techlabs.app.dto.StudentResponseDTO;
import com.techlabs.app.entity.Course;
import com.techlabs.app.entity.Student;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Mapper {

    // Convert StudentRequestDTO to Student entity
    public Student studentRequestToEntity(StudentRequestDTO studentRequestDTO) {
        if (studentRequestDTO == null) {
            return null;
        }

        Student student = new Student();
        student.setId(studentRequestDTO.getId());
        student.setName(studentRequestDTO.getName());
        student.setCgpa(studentRequestDTO.getCgpa());
        student.setMajor(studentRequestDTO.getMajor());
        student.setPhoneNumber(studentRequestDTO.getPhoneNumber());

        // Convert CourseRequestDTOs to Course entities
        Set<Course> courses = studentRequestDTO.getCourseRequests().stream()
                .map(dto -> {
                    Course course = new Course();
                    course.setId(dto.getId());
                    course.setName(dto.getName());
                    course.setLevel(dto.getLevel());
                    course.setCredits(dto.getCredits());
                    course.setEnrollmentCap(dto.getEnrollmentCap());
                    return course;
                })
                .collect(Collectors.toSet());

        student.setCourses(courses);

        // Set students in each course
        for (Course course : courses) {
            course.getStudents().add(student);
        }

        return student;
    }

    // Convert Student entity to StudentResponseDTO
    public StudentResponseDTO studentEntityToResponse(Student student) {
        if (student == null) {
            return null;
        }

        StudentResponseDTO responseDTO = new StudentResponseDTO();
        responseDTO.setId(student.getId());
        responseDTO.setName(student.getName());
        responseDTO.setCgpa(student.getCgpa());
        responseDTO.setMajor(student.getMajor());

        // Convert Course entities to CourseResponseDTOs
        Set<CourseResponseDTO> courseResponses = student.getCourses().stream()
                .map(course -> {
                    CourseResponseDTO dto = new CourseResponseDTO();
                    dto.setId(course.getId());
                    dto.setName(course.getName());
                    dto.setLevel(course.getLevel());
                    dto.setCredits(course.getCredits());
                    return dto;
                })
                .collect(Collectors.toSet());

        responseDTO.setCourseResponses(courseResponses);

        return responseDTO;
    }


    // Convert CourseRequestDTO to Course entity
    public Course courseRequestToEntity(CourseRequestDTO courseRequestDTO) {
        if (courseRequestDTO == null) {
            return null;
        }

        Course course = new Course();
        course.setId(courseRequestDTO.getId());
        course.setName(courseRequestDTO.getName());
        course.setLevel(courseRequestDTO.getLevel());
        course.setCredits(courseRequestDTO.getCredits());
        course.setEnrollmentCap(courseRequestDTO.getEnrollmentCap());

        // Convert student requests to Student entities using lambda expressions
        Set<Student> students = courseRequestDTO.getStudentRequests().stream()
                .map(dto -> {
                    Student student = new Student();
                    student.setId(dto.getId());
                    student.setName(dto.getName());
                    student.setCgpa(dto.getCgpa());
                    student.setMajor(dto.getMajor());
                    student.setPhoneNumber(dto.getPhoneNumber());
                    return student;
                })
                .collect(Collectors.toSet());

        // Set students for course
        course.setStudents(students);

        // Set courses in each student (if needed)
        for (Student student : students) {
            student.getCourses().add(course);
        }

        return course;
    }

    // Convert Course entity to CourseResponseDTO
    public CourseResponseDTO courseEntityToResponse(Course course) {
        if (course == null) {
            return null;
        }

        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
        courseResponseDTO.setId(course.getId());
        courseResponseDTO.setName(course.getName());
        courseResponseDTO.setLevel(course.getLevel());
        courseResponseDTO.setCredits(course.getCredits());

        Set<StudentResponseDTO> students = course.getStudents().stream().map(student->{
            StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
            studentResponseDTO.setId(student.getId());
            studentResponseDTO.setName(student.getName());
            studentResponseDTO.setMajor(student.getMajor());
            studentResponseDTO.setCgpa(student.getCgpa());
            return studentResponseDTO;
        }).collect(Collectors.toSet());

        courseResponseDTO.setStudentResponses(students);

        for(StudentResponseDTO studentResponseDTO : students){
            studentResponseDTO.getCourseResponses().add(courseResponseDTO);
        }

        return courseResponseDTO;
    }
}
