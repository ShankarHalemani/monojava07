package com.techlabs.strcutural.composite.model;

public class Manager implements IEmployee{
    private String managerName;
    private String managerPosition;

    public Manager(String managerName, String managerPosition) {
        this.managerName = managerName;
        this.managerPosition = managerPosition;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPosition() {
        return managerPosition;
    }

    public void setManagerPosition(String managerPosition) {
        this.managerPosition = managerPosition;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println("Employee Name : "+this.managerName);
        System.out.println("Employee Position : "+this.managerPosition);
    }
}
