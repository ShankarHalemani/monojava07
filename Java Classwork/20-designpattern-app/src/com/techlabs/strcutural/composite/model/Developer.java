package com.techlabs.strcutural.composite.model;

public class Developer implements IEmployee{
    private String developerName;
    private String developerPosition;

    public Developer(String developerName, String developerPosition) {
        this.developerName = developerName;
        this.developerPosition = developerPosition;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getDeveloperPosition() {
        return developerPosition;
    }

    public void setDeveloperPosition(String developerPosition) {
        this.developerPosition = developerPosition;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println("Employee Name : "+this.developerName);
        System.out.println("Employee Position : "+this.developerPosition);
    }
}
