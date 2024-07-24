package com.techlabs.app.dao;

import com.techlabs.app.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    void addEmployee(Employee employee);

    void addEmployees(List<Employee> employees);

    Employee displayEmployee(int employeeId);

    List<Employee> displayAllEmployees();

    void removeEmployee(int employeeId);


    void removeEmployees(List<Integer> employeeIds);

    List<Employee> displayEmployeesByFirstName(String firstName);

    void updateEmployee(Employee employee);

    void updateEmployeeWithoutMerge(Employee employee);
}
