package com.techlabs.app.service;

import com.techlabs.app.entity.Course;
import com.techlabs.app.entity.Instructor;
import com.techlabs.app.repository.CourseRepository;
import com.techlabs.app.repository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    private InstructorRepository instructorRepository;
    private CourseRepository courseRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository, CourseRepository courseRepository) {
        this.instructorRepository = instructorRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor getInstructorById(int id) {
        return instructorRepository.findById(id).orElse(null);
    }

    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public void deleteInstructor(Instructor instructor) {
        instructorRepository.delete(instructor);
    }

    @Override
    public Instructor assignInstructor(int id, int cid) {
        Instructor instructor = instructorRepository.findById(id).orElse(null);
        if (instructor != null) {
            Course course = courseRepository.findById(cid).orElse(null);
            if (course.getInstructor() == null) {
                instructor.addCourse(course);
                course.setInstructor(instructor);
                instructorRepository.save(instructor);
                return instructor;
            } else
                System.out.println("Already Instructor exists for this course");
        }
        return null;
    }

    @Override
    public Instructor deassignInstructor(int id, int cid) {
        Instructor instructor = instructorRepository.findById(id).orElse(null);
        if(instructor!=null){
            Course course = courseRepository.findById(cid).orElse(null);
            if(course!=null){
                instructor.removeCourse(course);
                courseRepository.save(course);
                return instructorRepository.save(instructor);
            }
        }
        return null;
    }
}
