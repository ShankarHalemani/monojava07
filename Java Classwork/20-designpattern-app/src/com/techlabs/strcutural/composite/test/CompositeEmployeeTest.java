package com.techlabs.strcutural.composite.test;

import com.techlabs.strcutural.composite.model.Developer;
import com.techlabs.strcutural.composite.model.EmployeeDirectory;
import com.techlabs.strcutural.composite.model.IEmployee;
import com.techlabs.strcutural.composite.model.Manager;

public class CompositeEmployeeTest {
    public static void main(String[] args) {
        IEmployee developer1 = new Developer("Shankar", "Junior Developer");
        IEmployee developer2 = new Developer("Shashank", "Senior Developer");

        EmployeeDirectory developerDirectory = new EmployeeDirectory();
        developerDirectory.addEmployees(developer1);
        developerDirectory.addEmployees(developer2);

        IEmployee manager1 = new Manager("Fayaz", "Junior Manager");
        IEmployee manager2 = new Manager("Shravan", "Senior Manager");

        EmployeeDirectory managerDirectory = new EmployeeDirectory();
        managerDirectory.addEmployees(manager1);
        managerDirectory.addEmployees(manager2);


        EmployeeDirectory compositeDirectory = new EmployeeDirectory();
        compositeDirectory.addEmployees(developerDirectory);
        compositeDirectory.addEmployees(managerDirectory);

        System.out.println("Employee Details :");
        compositeDirectory.showEmployeeDetails();

    }
}
