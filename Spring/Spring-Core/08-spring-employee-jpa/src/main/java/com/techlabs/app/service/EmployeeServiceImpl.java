package com.techlabs.app.service;

import com.techlabs.app.dto.EmployeeRequestDTO;
import com.techlabs.app.dto.EmployeeResponseDTO;
import com.techlabs.app.entity.Employee;
import com.techlabs.app.exception.EmployeeNotFoundException;
import com.techlabs.app.repository.EmployeeRepository;
import com.techlabs.app.util.PagedResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository eRepository;

    public EmployeeServiceImpl(EmployeeRepository eRepository) {
        this.eRepository = eRepository;
    }

    public Employee convertRequestDTOtoEntity(EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = new Employee();
        if (employeeRequestDTO.getId() != 0) {
            employee.setEmployeeId(employeeRequestDTO.getId());
        }
        employee.seteName(employeeRequestDTO.getName());
        employee.seteEmail(employeeRequestDTO.getEmail());
        employee.seteDesignation(employeeRequestDTO.getDesignation());
        employee.seteSalary(employeeRequestDTO.getSalary());
        employee.seteActive(employeeRequestDTO.isActive());
        return employee;
    }

    public EmployeeResponseDTO convertEntityToResponseDTO(Employee employee) {
        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
        employeeResponseDTO.setId(employee.getEmployeeId());
        employeeResponseDTO.setName(employee.geteName());
        employeeResponseDTO.setEmail(employee.geteEmail());
        employeeResponseDTO.setDesignation(employee.geteDesignation());
        return employeeResponseDTO;
    }

    public List<EmployeeResponseDTO> getResponseList(List<Employee> employees) {
        List<EmployeeResponseDTO> employeeResponseDTOList = new ArrayList<>();
        for (Employee employee : employees) {
            employeeResponseDTOList.add(convertEntityToResponseDTO(employee));
        }
        return employeeResponseDTOList;
    }

    @Override
    public PagedResponse<EmployeeResponseDTO> getAllEmployees(int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase(Sort.Direction.DESC.name()) ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Employee> employeePage = eRepository.findAll(pageable);
        List<Employee> employees = employeePage.getContent();
        List<EmployeeResponseDTO> responseList = getResponseList(employees);
        return new PagedResponse<>(responseList, employeePage.getNumber(), employeePage.getSize(),
                employeePage.getTotalElements(), employeePage.getTotalPages(), employeePage.isLast());
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(int employeeId) {
        Employee employee = eRepository.findById(employeeId).orElse(null);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with EID : " + employeeId + " not found");
        }
        return convertEntityToResponseDTO(employee);
    }

    @Override
    public EmployeeResponseDTO updateEmployee(EmployeeRequestDTO requestDTO) {
        Employee tempEmployee = eRepository.findById(requestDTO.getId()).orElse(null);
        if (tempEmployee == null) {
            throw new EmployeeNotFoundException("Employee with EID : " + requestDTO.getId() + " not found");
        }
        return convertEntityToResponseDTO(eRepository.save(convertRequestDTOtoEntity(requestDTO)));
    }

    @Override
    public void deleteEmployee(int employeeId) {
        Employee employee = eRepository.findById(employeeId).orElse(null);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with EID : " + employeeId + " not found");
        }
        eRepository.delete(employee);
    }

    @Override
    public List<EmployeeResponseDTO> getEmployeesByName(String empName) {
        List<Employee> employees = eRepository.findByENameLike(empName);
//        List<Employee> employees = eRepository.getByName(empName);
//        List<Employee> employees = eRepository.findByNameNative(empName);
        if (employees == null || employees.isEmpty()) {
            throw new EmployeeNotFoundException("There are no employees with name : " + empName);
        }
        return getResponseList(employees);
    }

    @Override
    public List<EmployeeResponseDTO> getEmployeesByEmail(String empEmail) {
        List<Employee> employees = eRepository.findByEEmail(empEmail);
//        List<Employee> employees = eRepository.getByEmail(empEmail);
//        List<Employee> employees = eRepository.findByEmailNative(empEmail);
        if (employees == null || employees.isEmpty()) {
            throw new EmployeeNotFoundException("There are no employees with email : " + empEmail);
        }
        return getResponseList(employees);
    }

    @Override
    public List<EmployeeResponseDTO> getAllActiveEmployees(boolean isActive) {
        List<Employee> employeeList = eRepository.findByEActive(isActive);
//        List<Employee> employeeList = eRepository.getByActive(isActive);
//        List<Employee> employeeList = eRepository.findByActiveNative(isActive);
        if (employeeList == null || employeeList.isEmpty()) {
            throw new EmployeeNotFoundException("There are no employees which are active right now");
        }
        return getResponseList(employeeList);
    }

    @Override
    public List<EmployeeResponseDTO> getEmployeesStartingWithChar(String charName) {
        List<Employee> employeeList = eRepository.findByENameStartingWith(charName);
//        List<Employee> employeeList = eRepository.getNameStartingWith(charName);
//        List<Employee> employeeList = eRepository.findNameStartingWithNative(charName);
        if (employeeList == null || employeeList.isEmpty()) {
            throw new EmployeeNotFoundException("There are no employees whose name starts with : " + charName);
        }
        return getResponseList(employeeList);
    }

    @Override
    public List<EmployeeResponseDTO> getEmployeesWithSalaryAndDesignation(double salary, String designation) {
        List<Employee> employeeList = eRepository.findByESalaryGreaterThanAndEDesignationLike(salary, designation);
//        List<Employee> employeeList = eRepository.getEmployeeWithSalaryGreaterThanAndDesignation(salary, designation);
//        List<Employee> employeeList = eRepository.findEmployeesBySalaryGreaterThanAndDesignationNative(salary, designation);
        if (employeeList == null || employeeList.isEmpty()) {
            throw new EmployeeNotFoundException("There are no employees with salary greater than : " + salary + " whose " +
                    "designation is : " + designation);
        }
        return getResponseList(employeeList);
    }

    @Override
    public List<EmployeeResponseDTO> getEmployeesWithSalaryRange(double startSalary, double endSalary) {
        List<Employee> employeeList = eRepository.findByESalaryBetween(startSalary, endSalary);
//        List<Employee> employeeList = eRepository.getEmployeeBySalaryBetween(startSalary, endSalary);
//        List<Employee> employeeList = eRepository.findEmployeesBySalaryBetweenNative(startSalary, endSalary);
        if (employeeList == null || employeeList.isEmpty()) {
            throw new EmployeeNotFoundException("There are no employees with salary range " + startSalary + " and " + endSalary);
        }
        return getResponseList(employeeList);
    }

    @Override
    public List<EmployeeResponseDTO> getEmployeesActiveAndSalary(boolean isActive, double salary) {
        List<Employee> employeeList = eRepository.findByEActiveAndESalary(isActive, salary);
//        List<Employee> employeeList = eRepository.getEmployeeByActiveAndSalary(isActive, salary);
//        List<Employee> employeeList = eRepository.findEmployeesByActiveAndSalaryNative(isActive, salary);
        if (employeeList == null || employeeList.isEmpty()) {
            throw new EmployeeNotFoundException("There are no employees with salary : " + salary + " and are active");
        }
        return getResponseList(employeeList);
    }

    @Override
    public int getCountEmployeesActive(boolean isActive) {
        int employeeCount = eRepository.countByEActive(isActive);
//        int employeeCount = eRepository.countEmployeesByActive(isActive);
//        int employeeCount = eRepository.countEmployeesByActiveNative(isActive);
        if (employeeCount == 0) {
            throw new EmployeeNotFoundException("There are no employees who are active");
        }
        return employeeCount;
    }

    @Override
    public int getCountEmployeesDesignation(String designation) {
        int employeeCount = eRepository.countByEDesignationLike(designation);
//        int employeeCount = eRepository.countEmployeesByDesignation(designation);
//        int employeeCount = eRepository.countEmployeesByDesignationNative(designation);
        if (employeeCount == 0) {
            throw new EmployeeNotFoundException("There are no employees who are : " + designation);
        }
        return employeeCount;
    }
}
