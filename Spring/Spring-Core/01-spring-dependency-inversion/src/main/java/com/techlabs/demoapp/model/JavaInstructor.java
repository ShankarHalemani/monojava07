package com.techlabs.demoapp.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class JavaInstructor implements Instructor{
    @Override
    public String getTrainingPlan() {
        return "Helo guys - Java Instructor";
    }
}
