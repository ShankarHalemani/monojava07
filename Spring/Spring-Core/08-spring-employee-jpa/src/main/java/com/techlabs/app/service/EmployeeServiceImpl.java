package com.techlabs.app.service;

import com.techlabs.app.entity.Employee;
import com.techlabs.app.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository eRepository;

    public EmployeeServiceImpl(EmployeeRepository eRepository) {
        this.eRepository = eRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return eRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return eRepository.findById(employeeId).orElse(null);
        /*
        Optional<Employee> employee = eRepository.findById(employeeId);
        if(employee.isPresent()){
            employee.get();
        }
        return null;
         */
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return eRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Employee employeeId) {
        eRepository.delete(employeeId);
    }
}
