<%@page import="java.util.ArrayList"%>
<%@page import="com.techlabs.model.Employee"%>
<%@page import="java.util.List"%>
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
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

</head>
<body>
	<%
	List<Employee> employees = new ArrayList<Employee>();

	employees.add(new Employee(1, "Shankar", 10000));
	employees.add(new Employee(2, "Deepak", 20000));
	employees.add(new Employee(3, "Deepa", 30000));
	employees.add(new Employee(4, "Shashank", 40000));
	employees.add(new Employee(5, "Soumya", 50000));

	pageContext.setAttribute("theEmployees", employees);
	%>

	<div class="container">

		<table border="1">
			<thead>
				<tr>

					<th>Employee ID</th>
					<th>Employee Name</th>
					<th>Employee Salary</th>
					<th>Salary Type</th>

				</tr>
			</thead>

			<tbody>

				<c:forEach var="employee" items="${theEmployees}">

					<tr>

						<td>${employee.employeeId}</td>
						<td>${employee.employeeName}</td>
						<td>${employee.salary}</td>
						<td><c:if test="${employee.salary>=20000 }">
						High
						</c:if></td>
						<td><c:if test="${employee.salary<20000 }">
						Low
						</c:if></td>

					</tr>


				</c:forEach>

			</tbody>
		</table>

	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

</body>
</html>