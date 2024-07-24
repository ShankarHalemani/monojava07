package com.techlabs.demoapp.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PythonInstructor implements Instructor {

    private Resource resource;

    public PythonInstructor(@Qualifier("videoResource") Resource resource) {
        super();
        this.resource = resource;
    }

    @Override
    public String getTrainingPlan() {
        return "Practice Python";
    }

    @Override
    public String getResource() {
        return this.resource.getResourceMaterial();
    }
}
