package com.techlabs.app.service;

import com.techlabs.app.entity.Address;
import com.techlabs.app.entity.Employee;
import com.techlabs.app.repository.AddressRepository;
import com.techlabs.app.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private AddressRepository addressRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AddressRepository addressRepository) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public Address getAddressById(int id) {
        return addressRepository.findAddressById(id);
    }

    @Override
    public Employee getEmployeeByAddressId(int id) {
        Address address = addressRepository.findAddressById(id);
        if (address != null) {
            Employee employee = address.getEmployee();
            return employee;
        }
        return null;
    }
}
