package com.techlabs.app.service;

import com.techlabs.app.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(int employeeId);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Employee employeeId);
}
