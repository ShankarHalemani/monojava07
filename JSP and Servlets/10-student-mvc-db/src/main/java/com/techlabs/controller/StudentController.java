
//	Run this file on server

package com.techlabs.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.techlabs.dao.StudentDbUtil;
import com.techlabs.model.Gender;
import com.techlabs.model.Student;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDbUtil studentDbUtil;

	@Resource(name = "jdbc/student")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();
		studentDbUtil = new StudentDbUtil(dataSource);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String command = request.getParameter("command");
		System.out.println(command);

		if (command == null) {
			command = "list";
		}

		switch (command) {
		case "add": {
			addStudent(request, response);
			break;
		}

		case "load": {
			loadStudent(request, response);
			break;
		}

		case "delete": {
			deleteStudent(request, response);
			break;
		}

		case "update": {
			updateStudent(request, response);
			break;
		}

		case "search": {
			searchStudent(request, response);
			break;
		}
		default:
			listStudent(request, response);
		}

	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Student> studentList = studentDbUtil.getStudents();
		request.setAttribute("theStudentsList", studentList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("view-students.jsp");
		requestDispatcher.forward(request, response);

	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");

		Date dateOfBirth = null;
		try {
			dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Gender gender = Gender.valueOf(request.getParameter("gender"));

		Student student = new Student(0, first_name, last_name, email, dateOfBirth, gender);
		boolean added = studentDbUtil.addStudents(student);
		System.out.println(added);

		response.sendRedirect(request.getContextPath() + "/StudentController");

	}

	private void loadStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		Student student = studentDbUtil.getStudent(id);

		request.setAttribute("theStudentList", student);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("update-student.jsp");
		requestDispatcher.forward(request, response);

	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		Date dateOfBirth = null;
		try {
			dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Gender gender = Gender.valueOf(request.getParameter("gender"));

		Student student = new Student(id, first_name, last_name, email, dateOfBirth, gender);
		studentDbUtil.updateStudent(student);

		response.sendRedirect(request.getContextPath() + "/StudentController");

	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		Student student = studentDbUtil.getStudent(id);
		studentDbUtil.deleteStudent(student);

		response.sendRedirect(request.getContextPath() + "/StudentController");
	}

	private void searchStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("search_student");
		List<Student> students = studentDbUtil.searchStudents(firstName);

		request.setAttribute("theStudentsList", students);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("view-students.jsp");
		requestDispatcher.forward(request, response);

//		response.sendRedirect(request.getContextPath() + "/StudentController");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
