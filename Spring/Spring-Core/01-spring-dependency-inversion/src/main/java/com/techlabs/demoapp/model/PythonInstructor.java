package com.techlabs.demoapp.model;

import org.springframework.stereotype.Component;

@Component
public class PythonInstructor implements Instructor{
    public String getTrainingPlan() {
        return "Helo guys - Pyhthon Instructor";
    }
}
