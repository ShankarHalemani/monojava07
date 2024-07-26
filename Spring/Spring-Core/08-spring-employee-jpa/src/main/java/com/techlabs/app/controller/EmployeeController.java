package com.techlabs.app.controller;

import com.techlabs.app.entity.Employee;
import com.techlabs.app.exception.EmployeeNotFoundException;
import com.techlabs.app.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;
//Constructor injector
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employeeList = employeeService.getAllEmployees();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/employees/{eid}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "eid") int employeeId){
        Employee employee = employeeService.getEmployeeById(employeeId);
        if(employee==null){
            throw new EmployeeNotFoundException("Employee with EID : "+employeeId+" not found");
        }
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        employee.setEmployeeId(0);
        Employee employee1 = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(employee1,HttpStatus.CREATED);
    }

    @PutMapping("/employees")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee tempEmployee = employeeService.getEmployeeById(employee.getEmployeeId());
        if(tempEmployee ==null){
            throw new EmployeeNotFoundException("Employee with EID : "+employee.getEmployeeId()+" not found");
        }
        Employee employee1 = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(employee1,HttpStatus.OK);
    }

    @DeleteMapping("/employees/{eid}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable(name = "eid") int employeeId){
        Employee employee = employeeService.getEmployeeById(employeeId);
        if(employee==null){
            throw new EmployeeNotFoundException("Employee with EID : "+employeeId+" not found");
        }
        employeeService.deleteEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
