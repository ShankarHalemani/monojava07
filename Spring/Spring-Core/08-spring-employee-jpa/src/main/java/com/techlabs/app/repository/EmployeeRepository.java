package com.techlabs.app.repository;

import com.techlabs.app.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByENameLike(String empName);

    List<Employee> findByEEmail(String empEmail);

    List<Employee> findByEActive(boolean isActive);

    List<Employee> findByENameStartingWith(String charName);

    List<Employee> findByESalaryGreaterThanAndEDesignationLike(double salary, String designation);

    List<Employee> findByESalaryBetween(double startSalary, double endSalary);

    List<Employee> findByEActiveAndESalary(boolean isActive, double salary);

    int countByEActive(boolean isActive);

    int countByEDesignationLike(String designation);
}
