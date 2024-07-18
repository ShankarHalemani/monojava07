<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="includes/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
<%@include file="includes/bootstrapcss.jsp"%>
</head>
<body>
	<%@include file="includes/header.jsp"%>

	<hr />

	<nav class="navbar bg-body-tertiary">
		<div
			class="container-fluid d-flex justify-content-center align-items-center">
			<h1 class="navbar-brand my-2">Admin Home</h1>
		</div>
	</nav>

	<hr />

	<nav class="navbar navbar-expand-lg bg-body-tertiary px-5">
		<div class="container-fluid">
			<a class="navbar-brand nav-link" href="add-new-customer.jsp">Add New Customer</a> <a
				class="navbar-brand nav-link" href="add-bank-account.jsp">Add Bank Account</a> <a
				class="navbar-brand nav-link" href="view-customers.jsp">View Customers</a> <a
				class="navbar-brand nav-link" href="view-transactions.jsp">View Transactions</a>
		</div>
	</nav>

	<div class="text-center mt-4">
		<img
			src="./includes/bank.jpeg"
			class="rounded img-fluid" alt="Bank-image" width="50%" />
	</div>

	<%@include file="includes/bootstrapjs.jsp"%>
</body>
</html>