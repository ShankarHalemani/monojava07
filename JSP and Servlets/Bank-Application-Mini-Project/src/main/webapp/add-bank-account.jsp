<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="includes/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Account</title>
<%@include file="includes/bootstrapcss.jsp"%>
</head>
<body>
	<%@include file="includes/header.jsp"%>
	<hr />

	<nav class="navbar bg-body-tertiary">
		<div
			class="container-fluid d-flex justify-content-center align-items-center">
			<h1 class="navbar-brand my-2 py-2">Add New Account</h1>
		</div>
	</nav>

	<hr />

	<form>
		<div class="container">
			<div class="mb-3">
				<input type="number" class="form-control" name="customer-id"
					placeholder="Enter Customer ID to Search" />
			</div>
			<div class="d-grid gap-2 col-3 mx-auto">
				<button type="submit" class="btn btn-primary">Search</button>
			</div>
		</div>
	</form>

	<div class="container my-5">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Customer ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email ID</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="customer" items="${theCustomersList}">
					<tr>
						<td>${customer.customerId}</td>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.emailId}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="d-grid gap-2 col-3 mx-auto mt-2">
			<button class="btn btn-outline-secondary" type="button">Generate
				Account Number</button>
		</div>
	</div>


	<%@include file="includes/bootstrapjs.jsp"%>
</body>
</html>