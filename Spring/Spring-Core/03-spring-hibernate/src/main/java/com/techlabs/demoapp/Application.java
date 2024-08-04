package com.techlabs.demoapp;

import com.techlabs.demoapp.dao.StudentDao;
import com.techlabs.demoapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private StudentDao studentDao;

	public Application(StudentDao student) {
		this.studentDao=student;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("HelloWorld");
//		addStudent();
//		getAllStudents();
//		getStudentById();
//		getStudentByFirstName();
//		getStudentByFirstNameAndLastName();
//		updateStudent();
//		deleteStudent();
//		updateStudentWithoutMerge();
		deleteAllStudentsIdLessThan();
	}

	private void deleteAllStudentsIdLessThan() {
		studentDao.deleteStudentIdLessThan(5);
	}

	private void updateStudentWithoutMerge() {
		Student student = new Student(2, "Satyansh","Narayana","sattu@gmail.com");
		studentDao.updateStudentWithoutMerge(student);
	}

	private void deleteStudent() {
		studentDao.deleteStudent(10);
	}

	private void updateStudent() {
		Student student = new Student(4, "Dipesh","Jain","deepu@gmail.com");
		studentDao.updateStudent(student);
	}


	private void getStudentByFirstNameAndLastName() {
		List<Student> studentList = studentDao.getStudentByFirstNameAndLastName("Shanmukh", "Negi");
		for(Student s : studentList){
			System.out.println(s);
		}
	}

	private void getStudentByFirstName() {
		List<Student> studentList=studentDao.getStudentByFirstName("Shanmukh");
		for(Student s : studentList){
			System.out.println(s);
		}
	}

	private void getStudentById() {
		Student student=studentDao.getStudentById(3);
		if(student!=null)
			System.out.println(student);
		else
			System.out.println("Student not found");
	}

	private void getAllStudents() {
		List<Student> studentList=studentDao.getAllStudents();
		for(Student s : studentList){
			System.out.println(s);
		}
	}

	private void addStudent() {
		Student student = new Student(0,"Shanmukh","Negi","shan@gmail.com");
		studentDao.save(student);
	}
}
