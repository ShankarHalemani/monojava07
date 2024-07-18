<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<body>
	<div class="container">

		<div class="text-center">

			<p>Update Student</p>

		</div>

		<form action="StudentController">

			<input type="hidden" name="command" value="update"> <input
				type="hidden" name="id" value="${theStudentList.studentId}">
			<div class="mb-3">
				<label for="first_name" class="form-label">First Name</label> <input
					type="text" class="form-control" id="first_name" name="first_name"
					value="${theStudentList.firstName}">
			</div>
			<div class="mb-3">
				<label for="first_name" class="form-label">Last Name</label> <input
					type="text" class="form-control" id="last_name" name="last_name"
					value="${theStudentList.lastName}">
			</div>

			<div class="mb-3">
				<label for="email" class="form-label">Email address</label> <input
					type="email" class="form-control" id="email" name="email"
					value="${theStudentList.emailId}">
			</div>

			<div class="mb-3">
				<label for="birthDate" class="form-label">Date of Birth:</label> <input
					type="date" class="form-control" id="birthDate" name="birthDate"
					value="${theStudentList.date}">
			</div>




			<div class="mb-3">
				<label class="form-label">Gender</label>
				<div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="gender"
							id="male" value="Male"
							${theStudentList.genderType == 'Male' ? 'checked' : ''}> <label
							class="form-check-label" for="male">Male</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="gender"
							id="female" value="Female"
							${theStudentList.genderType == 'Female' ? 'checked' : ''}> <label
							class="form-check-label" for="female">Female</label>
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>