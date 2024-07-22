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
	<div class="container mt-3">

		<nav class="navbar bg-secondary border rounded p-4">
			<div
				class="container-fluid d-flex justify-content-center align-items-center">
				<h1>Admin Home</h1>

			</div>
		</nav>


		<nav
			class="navbar navbar-expand-lg navbar-light bg-light mt-3 px-5 border rounded">
			<form action="admin" method="get">
				<nav class="navbar navbar-expand-lg bg-body-tertiary px-5">
					<div class="container-fluid">

						<button type="submit" name="admin-function"
							value="add-new-customer" class="navbar-brand nav-link col-3 me-3">Add
							New Customer</button>
						<button type="submit" name="admin-function"
							value="add-bank-account" class="navbar-brand nav-link col-5 me-3">Add
							Bank Account</button>
						<button type="submit" name="admin-function" value="view-customers"
							class="navbar-brand nav-link col-5 me-3">View Customers</button>
						<button type="submit" name="admin-function"
							value="view-transactions" class="navbar-brand nav-link col-5 me-3">View
							Transactions</button>
					</div>
				</nav>
			</form>
		</nav>

		<div class="text-center mt-4">
			<img src="./includes/bank.jpeg" class="rounded img-fluid"
				alt="Bank-image" width="60%" />
		</div>

		<form action="logout" method="get">
			<div class="form-group row mt-4">
				<div class="col text-center">
					<button type="submit" class="btn btn-warning">Logout</button>
				</div>
			</div>
		</form>

	</div>



	<%@include file="includes/bootstrapjs.jsp"%>
</body>
</html>