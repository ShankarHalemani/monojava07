<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">

		<a href="add-student.jsp" class="btn btn-dark">Add Student</a>
		<div class="my-3">
		
		<a href="search-student.jsp" class="btn btn-dark">Search Student</a>
		
		</div>
		

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Student ID</th>
					<th>Student First Name</th>
					<th>Student Last Name</th>
					<th>Student Email ID</th>
					<th>Date of Birth</th>
					<th>Gender</th>
					<th>Update</th>
					<th>Delete</th>

				</tr>
			</thead>

			<tbody>

				<c:forEach var="student" items="${theStudentsList}">

					<tr>
						<td>${student.studentId}</td>
						<td>${student.firstName}</td>
						<td>${student.lastName}</td>
						<td>${student.emailId}</td>
						<td>${student.date}</td>
						<td>${student.genderType}</td>
						<td><a href="StudentController?command=load&id=${student.studentId}"
							class="btn btn-secondary">Update</a></td>
						<td><a href="StudentController?command=delete&id=${student.studentId}"
							class="btn btn-danger">Delete</a></td>
					</tr>


				</c:forEach>

			</tbody>
		</table>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>