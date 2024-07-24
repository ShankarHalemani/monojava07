package com.techlabs.demoapp.dao;

import com.techlabs.demoapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{
    private EntityManager entityManager;

    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
    this.entityManager.persist(student);
    }

    @Override
    public List<Student> getAllStudents() {
        TypedQuery<Student> query =entityManager.createQuery("SELECT s FROM Student s",Student.class);

        return  query.getResultList();
    }

    @Override
    public Student getStudentById(int id) {
        Student student = entityManager.find(Student.class,id);
        return student;
    }

    @Override
    public List<Student> getStudentByFirstName(String name) {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s WHERE firstName=?1",
                Student.class);
        query.setParameter(1,name);
        return query.getResultList();
    }

    @Override
    public List<Student> getStudentByFirstNameAndLastName(String firstName, String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROm Student s WHERE firstName=?1 AND lastName=?2", Student.class);
        query.setParameter(1,firstName);
        query.setParameter(2,lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        Student student1 = entityManager.find(Student.class, student.getStudentId());
        if(student1!=null){
            this.entityManager.merge(student);
        } else {
            System.out.println("Student ID does not exist"+student.getStudentId());
        }
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        Student student = entityManager.find(Student.class, id);
        if(student !=null){
            this.entityManager.remove(student);
        }else{
            System.out.println("Student with id : "+id+" does not exist");
        }
    }

    @Override
    @Transactional
    public void updateStudentWthoutMerge(Student student) {
        Student student1 = entityManager.find(Student.class, student.getStudentId());
        if(student1!=null){
//            Native query
            Query query = entityManager.createQuery("UPDATE Student s SET s.firstName=?1, s" +
                            ".lastName=?2, s.emailId=?3 WHERE s.studentId=?4");
            query.setParameter(1,student.getFirstName());
            query.setParameter(2,student.getLastName());
            query.setParameter(3,student.getEmailId());
            query.setParameter(4,student.getStudentId());
            int result=query.executeUpdate();
            System.out.println(result);
        } else
            System.out.println("Student not fount ID : "+student.getStudentId());
    }

    @Override
    @Transactional
    public void deleteStudentIdLessThan(int id) {
        Student student1 = entityManager.find(Student.class, id);
        if(student1!=null){
            Query query = entityManager.createQuery("DELETE FROM Student s WHERE s.studentId < ?1");
            query.setParameter(1,id);
            int result = query.executeUpdate();
            System.out.println(result);
        } else
            System.out.println("Student not fount ID : "+id);


    }


}
