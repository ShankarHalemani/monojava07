<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="includes/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Home</title>
<%@include file="includes/bootstrapcss.jsp"%>
</head>
<body>
	<div class="container mt-3">

		<nav class="navbar bg-secondary border rounded p-4">
			<div
				class="container-fluid d-flex justify-content-between align-items-center">
				<h1 class="flex-grow-1 text-center mb-0">Customer Home</h1>
				<c:forEach var="customer" items="${currentCustomer}">
					<ul class="list-group ms-0"
						style="background-color: #f8f9fa; max-width: 500px;">
						<li class="list-group-item text-end"
							style="background-color: #e9ecef;">Customer Name:
							${customer.firstName} ${customer.lastName}</li>
						<li class="list-group-item text-end"
							style="background-color: #e9ecef;">Customer ID:
							${customer.customerId}</li>
					</ul>
				</c:forEach>
			</div>
		</nav>




		<nav
			class="navbar navbar-expand-lg navbar-light bg-light mt-3 px-5 border rounded">
			<form action="user" method="get" class="w-100">
				<div class="d-flex justify-content-around">

					<button type="submit" name="customer-function" value="passbook"
						class="navbar-brand nav-link mx-2">Passbook</button>
					<button type="submit" name="customer-function"
						value="new-transaction" class="navbar-brand nav-link mx-2">New
						Transaction</button>
					<button type="submit" name="customer-function" value="edit-profile"
						class="navbar-brand nav-link mx-2">Edit Profile</button>
				</div>
			</form>
		</nav>

		<div class="text-center mt-4">
			<img src="./includes/bank.jpeg" class="rounded img-fluid"
				alt="Bank-image" width="60%" />
		</div>

		<form action="logout" method="get">
			<div class="form-group row my-4">
				<div class="col text-center">
					<button type="submit" class="btn btn-warning">Logout</button>
				</div>
			</div>
		</form>

	</div>

	<%@include file="includes/bootstrapjs.jsp"%>
</body>
</html>
