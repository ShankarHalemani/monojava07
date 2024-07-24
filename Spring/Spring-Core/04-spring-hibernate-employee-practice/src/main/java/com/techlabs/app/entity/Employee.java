package com.techlabs.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "employee_fname")
    private String firstName;

    @Column(name = "employee_lname")
    private String lastName;

    @Column(name = "employee_email")
    private String emailId;

    @Column(name = "job_id")
    private int jobId;

    @Column(name = "department_id")
    private int departmentId;

    public Employee() {
    }

    public Employee(int employeeId, String firstName, String lastName, String emailId, int jobId, int departmentId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.jobId = jobId;
        this.departmentId = departmentId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", jobId=" + jobId +
                ", departmentId=" + departmentId +
                '}';
    }
}
