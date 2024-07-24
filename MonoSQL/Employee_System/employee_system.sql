CREATE DATABASE employee_system;
USE employee_system;

-- Drop existing tables if they exist

DROP TABLE IF EXISTS salaries;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS departments;
DROP TABLE IF EXISTS jobs;

-- Create departments table
CREATE TABLE departments(
    department_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    department_name VARCHAR(50) NOT NULL
);

-- Create jobs table
CREATE TABLE jobs(
    job_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    job_title VARCHAR(50) NOT NULL,
    min_salary DECIMAL(10, 2),
    max_salary DECIMAL(10, 2)
);

-- Create employees table
CREATE TABLE employees(
    employee_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    employee_fname VARCHAR(50),
    employee_lname VARCHAR(50),
    employee_email VARCHAR(100),
    department_id INT,
    job_id INT,
    FOREIGN KEY (department_id) REFERENCES departments(department_id) ON DELETE CASCADE,
    FOREIGN KEY (job_id) REFERENCES jobs(job_id) ON DELETE CASCADE
) AUTO_INCREMENT = 2000;

-- Create salaries table
CREATE TABLE salaries(
    employee_id INT NOT NULL,
    salary DECIMAL(10, 2) NOT NULL,
    effective_date DATE NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id) ON DELETE CASCADE,
    PRIMARY KEY(employee_id, effective_date)
);

-- Insert data into departments table
INSERT INTO departments(department_name) VALUES
('Human Resources'),
('Finance'),
('Engineering'),
('Sales'),
('Marketing');

-- Insert data into jobs table
INSERT INTO jobs(job_title, min_salary, max_salary) VALUES
('HR Manager', 50000.00, 90000.00),
('Finance Analyst', 45000.00, 85000.00),
('Software Engineer', 60000.00, 120000.00),
('Sales Executive', 40000.00, 80000.00),
('Marketing Specialist', 45000.00, 85000.00);

-- Insert data into employees table
INSERT INTO employees(employee_fname, employee_lname, employee_email, department_id, job_id) VALUES
('Shankar', 'Halemai', 'shankar@gmail.com', 1, 1),
('Varish', 'Valleti', 'varish@gmail.com', 2, 2),
('Poojitha', 'Makkena', 'poojita@gmail.com', 3, 3),
('Neelanjana', 'Singh', 'NJbro@gmail.com', 4, 4),
('Aman', 'Yadav', 'aman@gmail.com', 5, 5),
('Agraha', 'Jain', 'agraha@gmail.com', 3, 3),
('Simran', 'Nadaf', 'simran@gmail.com', 4, 4);

-- Insert data into salaries table
INSERT INTO salaries(employee_id, salary, effective_date) VALUES
(2000, 70000.00, '2024-01-01'),
(2001, 65000.00, '2024-01-01'),
(2002, 95000.00, '2024-01-01'),
(2003, 60000.00, '2024-01-01'),
(2004, 50000.00, '2024-01-01'),
(2005, 95000.00, '2024-01-01'),
(2006, 60000.00, '2024-01-01');
