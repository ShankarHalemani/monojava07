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
		<nav class="navbar bg-secondary p-4 border rounded mt-3">
			<div
				class="container-fluid d-flex justify-content-center align-items-center">
				<h1>View Customers</h1>
			</div>
		</nav>

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