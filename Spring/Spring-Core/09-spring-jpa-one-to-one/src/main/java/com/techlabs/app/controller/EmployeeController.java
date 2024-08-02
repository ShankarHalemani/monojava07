package com.techlabs.app.controller;

import com.techlabs.app.entity.Address;
import com.techlabs.app.entity.Employee;
import com.techlabs.app.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @PostMapping
    public Employee addNewEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/id/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee tempEmployee = employeeService.getEmployeeById(employee.getId());
        if (tempEmployee != null) {
            return employeeService.saveEmployee(employee);
        }
        return null;
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteEmployee(@PathVariable(name = "id") int id) {
        Employee tempEmployee = employeeService.getEmployeeById(id);
        if (tempEmployee != null) {
            employeeService.deleteEmployee(tempEmployee);
        }
    }

    @GetMapping("/address/id/{id}")
    public Address getAddressById(@PathVariable(name = "id")int id){
        return employeeService.getAddressById(id);
    }

    @GetMapping("/employee-address/id/{id}")
    public Employee getEmployeeWithAddressId(@PathVariable(name = "id")int id){
        return employeeService.getEmployeeByAddressId(id);
    }

}
