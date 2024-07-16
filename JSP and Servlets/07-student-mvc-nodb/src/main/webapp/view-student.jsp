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
<body>
	<div class="container">

		<h1>Students List</h1>
		<table border="1">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email ID</th>

				</tr>
			</thead>

			<tbody>

				<c:forEach var="student" items="${theStudentList}">

					<tr>
						<td>${student.firstName}</td>
                        <td>${student.lastName}</td>
                        <td>${student.emailId}</td>
					</tr>


				</c:forEach>

			</tbody>
		</table>

	</div>
</body>
</html>