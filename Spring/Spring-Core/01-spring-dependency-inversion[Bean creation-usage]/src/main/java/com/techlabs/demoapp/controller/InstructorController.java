package com.techlabs.demoapp.controller;

import com.techlabs.demoapp.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstructorController {
//    field injector
    @Autowired
    @Qualifier(value="pythonInstructor")

    private Instructor instructor;

//    public InstructorController(@Qualifier(value="pythonInstructor") Instructor instructor) {
//        this.instructor = instructor;
//    }

    @GetMapping("/train")
    public String getMessage(){

        return this.instructor.getTrainingPlan()+"<br>"+this.instructor.getResource();
    }

//    setter injector
    @Autowired
    @Qualifier(value = "pythonInstructor")
    public void setInstructor(Instructor instructor){
        this.instructor=instructor;
    }
}
