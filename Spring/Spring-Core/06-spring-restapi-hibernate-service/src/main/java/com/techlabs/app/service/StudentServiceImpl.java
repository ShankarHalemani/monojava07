package com.techlabs.app.service;

import com.techlabs.app.dao.StudentDao;
import com.techlabs.app.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public Student getStudentById(int studentId) {
        return studentDao.getStudentById(studentId);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public void deleteStudent(Student studentId) {
        studentDao.deleteStudent(studentId);
    }
}
