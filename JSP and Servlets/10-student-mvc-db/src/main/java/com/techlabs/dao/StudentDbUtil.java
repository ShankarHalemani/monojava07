package com.techlabs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.techlabs.model.Gender;
import com.techlabs.model.Student;

public class StudentDbUtil {
	private DataSource dataSource;
	private List<Student> students;

	public StudentDbUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public List<Student> getStudents() {

		this.students = new ArrayList<Student>();

		try {
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();

			String selectQuery = "select * from `students`";
			ResultSet resultSet = statement.executeQuery(selectQuery);

			while (resultSet.next()) {
				int student_id = resultSet.getInt("student_id");
				String first_name = resultSet.getString("first_name");
				String last_name = resultSet.getString("last_name");
				String email = resultSet.getString("email");
				Date date = resultSet.getDate("date_of_birth");
				Gender gender = Gender.valueOf(resultSet.getString("gender"));

				students.add(new Student(student_id, first_name, last_name, email, date, gender));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

	public boolean addStudents(Student student) {
		try {
			Connection connection = dataSource.getConnection();
			String insertQuery = "insert into students(first_name, last_name, email, date_of_birth, gender) values(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, student.getFirstName());
			preparedStatement.setString(2, student.getLastName());
			preparedStatement.setString(3, student.getEmailId());
			preparedStatement.setDate(4, new java.sql.Date(student.getDate().getTime()));
			preparedStatement.setString(5, student.getGenderType().toString());

			int result = preparedStatement.executeUpdate();

			return result == 1 ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	public Student getStudent(int id) {
		Student student = null;

		Connection connection;
		try {
			connection = dataSource.getConnection();
			String selectQuery = "select * from `students` where student_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String first_name = resultSet.getString("first_name");
				String last_name = resultSet.getString("last_name");
				String email = resultSet.getString("email");
				Date date = resultSet.getDate("date_of_birth");
				Gender gender = Gender.valueOf(resultSet.getString("gender"));
				student = new Student(id, first_name, last_name, email, date, gender);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return student;
	}

	public void updateStudent(Student student) {

		try {
			Connection connection = dataSource.getConnection();
			String updateQuery = "update students set first_name=?, last_name=?, email=?, date_of_birth=?,gender=? where student_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, student.getFirstName());
			preparedStatement.setString(2, student.getLastName());
			preparedStatement.setString(3, student.getEmailId());
			preparedStatement.setDate(4, new java.sql.Date(student.getDate().getTime()));
			preparedStatement.setString(5, student.getGenderType().toString());
			preparedStatement.setInt(6, student.getStudentId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteStudent(Student student) {
		try {
			Connection connection = dataSource.getConnection();
			String deleteQuery = "delete from students where student_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, student.getStudentId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Student> searchStudents(String firstName) {

		List<Student> students = new ArrayList<Student>();
		Student student = null;

		try {
			Connection connection = dataSource.getConnection();
			String selectQuery = "SELECT * FROM students WHERE first_name LIKE ?";
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, "%" + firstName + "%");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int student_id = resultSet.getInt("student_id");
				String first_name = resultSet.getString("first_name");
				String last_name = resultSet.getString("last_name");
				String email = resultSet.getString("email");
				Date date = resultSet.getDate("date_of_birth");
				Gender gender = Gender.valueOf(resultSet.getString("gender"));
				student = new Student(student_id, first_name, last_name, email, date, gender);
				students.add(student);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return students;
	}

}
