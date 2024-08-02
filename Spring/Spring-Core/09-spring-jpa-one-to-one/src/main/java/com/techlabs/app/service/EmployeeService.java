package com.techlabs.app.service;

import com.techlabs.app.entity.Address;
import com.techlabs.app.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> findAllEmployees();

    Employee getEmployeeById(int id);

    void deleteEmployee(Employee employee);

    Address getAddressById(int id);

    Employee getEmployeeByAddressId(int id);
}
