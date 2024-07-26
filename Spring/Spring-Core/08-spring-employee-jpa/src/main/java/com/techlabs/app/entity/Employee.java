package com.techlabs.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "emp_id")
    private int employeeId;

    @Column(name = "emp_name")
    private String eName;

    @Column(name = "emp_email")
    private String eEmail;

    @Column(name = "emp_design")
    private String eDesignation;

    @Column(name = "emp_salary")
    private double eSalary;

    @Column(name = "emp_active")
    private boolean eActive;

    public Employee() {
    }

    public Employee(int employeeId, String eName, String eEmail, String eDesignation, double eSalary, boolean eActive) {
        this.employeeId = employeeId;
        this.eName = eName;
        this.eEmail = eEmail;
        this.eDesignation = eDesignation;
        this.eSalary = eSalary;
        this.eActive = eActive;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteEmail() {
        return eEmail;
    }

    public void seteEmail(String eEmail) {
        this.eEmail = eEmail;
    }

    public String geteDesignation() {
        return eDesignation;
    }

    public void seteDesignation(String eDesignation) {
        this.eDesignation = eDesignation;
    }

    public double geteSalary() {
        return eSalary;
    }

    public void seteSalary(double eSalary) {
        this.eSalary = eSalary;
    }

    public boolean iseActive() {
        return eActive;
    }

    public void seteActive(boolean eActive) {
        this.eActive = eActive;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", eName='" + eName + '\'' +
                ", eEmail='" + eEmail + '\'' +
                ", eDesignation='" + eDesignation + '\'' +
                ", eSalary=" + eSalary +
                ", eActive=" + eActive +
                '}';
    }
}
