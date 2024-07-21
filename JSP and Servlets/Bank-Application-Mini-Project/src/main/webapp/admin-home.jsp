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
						<input type="submit" name="admin-function"
							value="Add New Customer" class="navbar-brand nav-link col-3" />
						<input type="submit" name="admin-function"
							value="Add Bank Account" class="navbar-brand nav-link col-5" />
						<input type="submit" name="admin-function" value="View Customers"
							class="navbar-brand nav-link col-5" /> <input type="submit"
							name="admin-function" value="View Transactions"
							class="navbar-brand nav-link col-5" />
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
					<button type="submit" class="btn btn-primary">Logout</button>
				</div>
			</div>
		</form>

	</div>



	<%@include file="includes/bootstrapjs.jsp"%>
</body>
</html>