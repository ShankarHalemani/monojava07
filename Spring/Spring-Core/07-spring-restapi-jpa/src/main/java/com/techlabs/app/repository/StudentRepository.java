package com.techlabs.app.repository;

import com.techlabs.app.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

//Here Integer is type of primary Key of Student (studentId)
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
