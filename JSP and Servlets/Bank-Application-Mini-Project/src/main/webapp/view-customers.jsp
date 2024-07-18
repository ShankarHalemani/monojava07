<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="includes/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Customers</title>
<%@include file="includes/bootstrapcss.jsp"%>
</head>
<body>
	<%@include file="includes/header.jsp"%>
	<hr />

	<nav class="navbar bg-body-tertiary">
		<div
			class="container-fluid d-flex justify-content-center align-items-center">
			<h1 class="navbar-brand my-2 py-2">View Customers</h1>
		</div>
	</nav>

	<hr />

	<div class="container my-5">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Customer ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Account Number</th>
					<th>Balance</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="customer" items="${theCustomersList}">
					<tr>
						<td>${customer.customerId}</td>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.accountNumber}</td>
						<td>${customer.balance}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


	<%@include file="includes/bootstrapjs.jsp"%>
</body>
</html>