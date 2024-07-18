-- Create the database
CREATE DATABASE student;

-- Use the database
USE student;


DROP TABLE IF EXISTS `students`;
DROP TABLE IF EXISTS `courses`;
DROP TABLE IF EXISTS `enrollments`;
DROP TABLE IF EXISTS `grades`;

-- Create the students table
CREATE TABLE students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL,
    gender ENUM('Male', 'Female') NOT NULL
);

-- Create the courses table
CREATE TABLE courses (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    course_description TEXT
);

-- Create the enrollments table
CREATE TABLE enrollments (
    enrollment_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    course_id INT,
    enrollment_date DATE,
    FOREIGN KEY (student_id) REFERENCES students(student_id) ON DELETE CASCADE,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

-- Create the grades table
CREATE TABLE grades (
    grade_id INT AUTO_INCREMENT PRIMARY KEY,
    enrollment_id INT,
    grade ENUM('A', 'B', 'C', 'D', 'F'),
    FOREIGN KEY (enrollment_id) REFERENCES enrollments(enrollment_id) ON DELETE CASCADE
);

-- Insert sample students
INSERT INTO students (first_name, last_name, email, date_of_birth, gender) VALUES
('John', 'Doe', 'john.doe@example.com', '2000-01-15', 'Male'),
('Jane', 'Smith', 'jane.smith@example.com', '1999-05-22', 'Female'),
('Alice', 'Johnson', 'alice.johnson@example.com', '2001-09-10', 'Female'),
('Bob', 'Brown', 'bob.brown@example.com', '2000-03-30', 'Male');

-- Insert sample courses
INSERT INTO courses (course_name, course_description) VALUES
('Mathematics', 'An introduction to mathematical concepts and techniques.'),
('Physics', 'Fundamentals of physics, including mechanics and thermodynamics.'),
('Chemistry', 'Basic principles of chemistry and chemical reactions.'),
('Computer Science', 'Introduction to computer science and programming.');

-- Insert sample enrollments
INSERT INTO enrollments (student_id, course_id, enrollment_date) VALUES
(1, 1, '2023-09-01'),
(1, 2, '2023-09-01'),
(2, 2, '2023-09-01'),
(3, 3, '2023-09-01'),
(3, 4, '2023-09-01'),
(4, 1, '2023-09-01'),
(4, 4, '2023-09-01');

-- Insert sample grades
INSERT INTO grades (enrollment_id, grade) VALUES
(1, 'A'),
(2, 'B'),
(3, 'C'),
(4, 'B'),
(5, 'A'),
(6, 'D'),
(7, 'B');
