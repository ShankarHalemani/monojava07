package com.techlabs.app;

import com.techlabs.app.dao.EmployeeDao;
import com.techlabs.app.entity.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private Scanner scanner;
    private EmployeeDao employeeDao;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public Application(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
        this.scanner = new Scanner(System.in);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello");
//		addEmployee();
//		addEmployees();
//      displayEmployee();
//		displayAllEmployees();
//		removeEmployee();
//		removeEmployees();
//		displayEmployeesByFirstName();
//      updateEmployee();
        updateEmployeeWithoutMerge();
    }



    private void addEmployee() {
        Employee employee = new Employee(0, "Suyash", "Awasthy", "suyash@gmail.com", 3, 3);
        employeeDao.addEmployee(employee);
    }

    private void addEmployees() {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            System.out.println("First Name");
            String firstName = scanner.next();

            System.out.println("Last Name");
            String lastName = scanner.next();

            System.out.println("Email ID");
            String emailId = scanner.next();

            System.out.println("Job ID");
            int jobId = scanner.nextInt();

            System.out.println("Departmet ID");
            int departmentId = scanner.nextInt();

            Employee employee = new Employee(0, firstName, lastName, emailId, jobId, departmentId);
            employees.add(employee);
        }

        employeeDao.addEmployees(employees);
    }

    private void displayEmployee() {
        Employee employee = employeeDao.displayEmployee(2003);
        System.out.println(employee);
    }

    private void displayAllEmployees() {
        List<Employee> employeeList = employeeDao.displayAllEmployees();
        employeeList.forEach(employee -> System.out.println(employee.getFirstName()));
    }

    private void removeEmployee() {
        employeeDao.removeEmployee(2004);
    }

    private void removeEmployees() {
        List<Integer> employeeIds = new ArrayList<>();
        employeeIds.add(2002);
        employeeIds.add(2005);
        employeeDao.removeEmployees(employeeIds);
    }

    private void displayEmployeesByFirstName() {
        List<Employee> employees = employeeDao.displayEmployeesByFirstName("an");
        employees.forEach(employee -> System.out.println(employee.getFirstName()));
    }

    private void updateEmployee() {
        Employee employee = new Employee(2000,"Shankaraling","Halemani","shankaraling@gmail.com",2,3);
        employeeDao.updateEmployee(employee);
    }

    private void updateEmployeeWithoutMerge() {
        Employee employee = new Employee(2003,"Sneha","Sigh","njbro@gmail.com",1,1);
        employeeDao.updateEmployeeWithoutMerge(employee);
    }
}
