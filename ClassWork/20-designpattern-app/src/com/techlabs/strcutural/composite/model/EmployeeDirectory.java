package com.techlabs.strcutural.composite.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDirectory implements IEmployee{
    private List<IEmployee> employeeList;

    public EmployeeDirectory() {
        this.employeeList = new ArrayList<>();
    }

    public void addEmployees(IEmployee employee){
        this.employeeList.add(employee);
    }

    public void removeEmployee(IEmployee employee){
        this.employeeList.remove(employee);
    }

    @Override
    public void showEmployeeDetails() {
        for(IEmployee employee : employeeList){
            employee.showEmployeeDetails();
        }

    }
}
