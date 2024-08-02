package com.techlabs.app.controller;

import com.techlabs.app.entity.Course;
import com.techlabs.app.entity.Instructor;
import com.techlabs.app.service.InstructorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {
    private InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @GetMapping("/id/{id}")
    public Instructor getInstructorById(@PathVariable(name = "id") int id) {
        return instructorService.getInstructorById(id);
    }

    @PostMapping("/add")
    public Instructor addInstructor(@RequestBody Instructor instructor) {
        return instructorService.addInstructor(instructor);
    }

    @PutMapping("/update")
    public Instructor updateInstructor(@RequestBody Instructor instructor) {
        Instructor tempInstructor = instructorService.getInstructorById(instructor.getId());
        if (tempInstructor != null) {
            return instructorService.addInstructor(instructor);
        }
        return null;
    }


    @DeleteMapping("/remove/id/{id}")
    public void deleteInstructor(@PathVariable(name = "id") int id) {
        Instructor instructor = instructorService.getInstructorById(id);

        if (instructor != null) {
            List<Course> courses = instructor.getCourses();
            for (Course course : courses) {
                course.setInstructor(null);
            }
            instructorService.deleteInstructor(instructor);
        }
    }

    @PutMapping("/instructor/{id}/course/{cid}")
    public Instructor assignInstructor(@PathVariable(name = "id") int id, @PathVariable(name = "cid") int cid) {
        return instructorService.assignInstructor(id, cid);
    }

    @PutMapping("/instructor-{id}/course-{cid}")
    public Instructor deassignInstructor(@PathVariable(name = "id") int id, @PathVariable(name = "cid") int cid) {
        return instructorService.deassignInstructor(id, cid);
    }


}
