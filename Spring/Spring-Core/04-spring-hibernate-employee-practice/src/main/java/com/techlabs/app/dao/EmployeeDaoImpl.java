package com.techlabs.app.dao;

import com.techlabs.app.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private EntityManager entityManager;

    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        this.entityManager.persist(employee);
    }

    @Override
    @Transactional
    public void addEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            this.entityManager.persist(employee);
        }
    }

    @Override
    public Employee displayEmployee(int employeeId) {
        Employee employee = this.entityManager.find(Employee.class, employeeId);
        return employee;
    }

    @Override
    public List<Employee> displayAllEmployees() {
        TypedQuery<Employee> query = this.entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void removeEmployee(int employeeId) {
        Employee employee = this.entityManager.find(Employee.class, employeeId);
        if (employee != null) {
            this.entityManager.remove(employee);
        } else
            System.out.println("Not fount employee with employee ID : " + employeeId);
    }

    @Override
    @Transactional
    public void removeEmployees(List<Integer> employeeIds) {
        for (Integer employeeId : employeeIds) {
            Employee employee = this.entityManager.find(Employee.class, employeeId);
            if (employee != null) {
                this.entityManager.remove(employee);
            } else
                System.out.println("Employee with ID : " + employeeId + " not found");
        }
    }

    @Override
    public List<Employee> displayEmployeesByFirstName(String firstName) {
        TypedQuery<Employee> query = this.entityManager.createQuery("SELECT e FROM Employee e WHERE firstName LIKE " +
                "?1", Employee.class);
        String searchPattern = "%" + firstName + "%";
        query.setParameter(1, searchPattern);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        Employee employee1 = this.entityManager.find(Employee.class, employee.getEmployeeId());
        if (employee1 != null) {
            this.entityManager.merge(employee);
        } else {
            System.out.println("Employee with ID : " + employee.getEmployeeId() + " not found");
        }
    }

    @Override
    @Transactional
    public void updateEmployeeWithoutMerge(Employee employee) {
        Employee employee1 = this.entityManager.find(Employee.class, employee.getEmployeeId());
        if (employee1 != null) {
            Query query = this.entityManager.createQuery("UPDATE Employee e SET e.firstName =?1, e.lastName=?2, e" +
                    ".emailId=?3, e.jobId=?4, e.departmentId=?5 WHERE e.employeeId=?6");
            query.setParameter(1, employee.getFirstName());
            query.setParameter(2, employee.getLastName());
            query.setParameter(3, employee.getEmailId());
            query.setParameter(4, employee.getJobId());
            query.setParameter(5, employee.getDepartmentId());
            query.setParameter(6,employee.getEmployeeId());
            query.executeUpdate();
        } else {
            System.out.println("Employee with ID : " + employee.getEmployeeId() + " not found");
        }
    }
}
