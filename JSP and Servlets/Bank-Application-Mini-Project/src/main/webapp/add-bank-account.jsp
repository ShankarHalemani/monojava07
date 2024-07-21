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

	<div class="container">
		<nav class="navbar bg-secondary border rounded mt-3 p-4">
			<div
				class="container-fluid d-flex justify-content-center align-items-center">
				<h1>Add New Account</h1>
			</div>
		</nav>
		
		<c:if test="${not empty message}">
			<div class="alert alert-primary alert-dismissible fade show w-50 mx-auto my-3" role="alert">
				${message}
				<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>
		</c:if>
	</div>


	<form action="admin-function" method="post" class="mt-3">
		<input type="hidden" name="command" value="search-customer" />
		<div class="container">
			<div class="mb-3">
				<input type="text" class="form-control" name="customer-id"
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
				<c:forEach var="customer" items="${theCustomer}">
					<tr>
						<td>${customer.customerId}</td>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.emailId}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


		<form action="admin-function" method="post" class="mt-3">


			<c:forEach var="customer" items="${theCustomer}">
				<input type="hidden" name="customerId"
					value="${customer.customerId}" />
			</c:forEach>

			<input type="hidden" name="command" value="add-bank-account" />
			<div class="container mt-5">
				<div class="d-grid gap-2 col-3 mx-auto mt-2">
					<button class="btn btn-outline-secondary" type="submit">Generate
						Account Number</button>
				</div>
			</div>
		</form>
		
		<form action="admin" method="get">
					<div class="form-group row mt-4">
						<div class="col text-center">
							<button type="submit" name="admin-function"
								value="" class="btn btn-danger">Cancel</button>
						</div>
					</div>
				</form>


	</div>


	<%@include file="includes/bootstrapjs.jsp"%>
</body>
</html>