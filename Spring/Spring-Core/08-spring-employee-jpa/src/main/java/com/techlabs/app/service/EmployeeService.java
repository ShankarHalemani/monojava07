package com.techlabs.app.service;

import com.techlabs.app.dto.EmployeeRequestDTO;
import com.techlabs.app.dto.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseDTO> getAllEmployees();

    EmployeeResponseDTO getEmployeeById(int employeeId);

    EmployeeResponseDTO updateEmployee(EmployeeRequestDTO employee);

    void deleteEmployee(int employeeId);

    List<EmployeeResponseDTO> getEmployeesByName(String empName);

    List<EmployeeResponseDTO> getEmployeesByEmail(String empEmail);

    List<EmployeeResponseDTO> getAllActiveEmployees(boolean isActive);

    List<EmployeeResponseDTO> getEmployeesStartingWithChar(String charName);

    List<EmployeeResponseDTO> getEmployeesWithSalaryAndDesignation(double salary, String designation);

    List<EmployeeResponseDTO> getEmployeesWithSalaryRange(double startSalary, double endSalary);

    List<EmployeeResponseDTO> getEmployeesActiveAndSalary(boolean isActive, double salary);

    int getCountEmployeesActive(boolean isActive);

    int getCountEmployeesDesignation(String designation);
}
