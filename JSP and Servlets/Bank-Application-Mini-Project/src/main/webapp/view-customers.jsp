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

	<div class="container">

		<nav class="navbar bg-secondary mt-3 border rounded">
			<div
				class="container-fluid d-flex justify-content-between align-items-center">
				<div class="d-flex flex-grow-1 justify-content-center p-4">
					<h1 class="mb-0">View Customers</h1>
				</div>
				<form action="logout" method="get" class="mb-0">
					<div class="form-group row">
						<div class="col text-end">
							<button type="submit" class="btn btn-outline-light">Logout</button>
						</div>
					</div>
				</form>
			</div>
		</nav>


		<div class="row justify-content-center my-3">
			<div class="col-lg-8">
				<div class="card p-3">
					<div class="card-body">
						<form action="admin" method="get">
							<div class="d-flex">
								<select class="form-select me-2" name="admin-function" required>
									<option value="" disabled selected>Select Search Type</option>
									<option value="byCustomer-id">Customer ID</option>
									<option value="byCustomer-name">Customer Name</option>
								</select> <input type="text" class="form-control me-2"
									name="searchCustomer" placeholder="Enter search term" required>
								<button type="submit" class="btn btn-primary">Search</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>


		<table class="table table-striped table-bordered mt-3">
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
				<c:forEach var="customerAccount" items="${theCustomerAccounts}">
					<tr>
						<td>${customerAccount.customer.customerId}</td>
						<td>${customerAccount.customer.firstName}</td>
						<td>${customerAccount.customer.lastName}</td>
						<td>${customerAccount.account.accountNumber}</td>
						<td>${customerAccount.account.balance}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


		<form action="admin" method="get">
			<div class="form-group row my-4">
				<div class="col text-center">
					<button type="submit" name="admin-function" value=""
						class="btn btn-danger">Cancel</button>
				</div>
			</div>
		</form>
	</div>


	<%@include file="includes/bootstrapjs.jsp"%>
</body>
</html>