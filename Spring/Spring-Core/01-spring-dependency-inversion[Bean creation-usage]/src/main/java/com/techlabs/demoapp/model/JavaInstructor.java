package com.techlabs.demoapp.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class JavaInstructor implements Instructor {

    private Resource resource;

    public JavaInstructor(@Qualifier("pdfResource") Resource resource) {
        super();
        this.resource = resource;
    }

    @Override
    public String getTrainingPlan() {
        return "Practice Java";
    }

    @Override
    public String getResource() {
        return this.resource.getResourceMaterial();
    }
}
