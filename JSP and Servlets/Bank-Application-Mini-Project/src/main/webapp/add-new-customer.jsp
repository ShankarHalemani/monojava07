<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="includes/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Customer</title>
<%@include file="includes/bootstrapcss.jsp"%>
</head>
<body>
	<%@include file="includes/header.jsp"%>
	<hr />

	<nav class="navbar bg-body-tertiary">
		<div
			class="container-fluid d-flex justify-content-center align-items-center">
			<h1 class="navbar-brand my-2 py-2">Add New Customer</h1>
		</div>
	</nav>

	<hr />

	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-body">
				<form action="cutomer" method="post">
					<div class="form-group mb-3">
						<label>First Name</label> <input type="email" class="form-control"
							name="customer-fname" placeholder="Enter email" required />
					</div>

					<div class="form-group mb-3">
						<label>Last Name</label> <input type="email" class="form-control"
							name="customer-lname" placeholder="Enter email" required />
					</div>

					<div class="form-group mb-3">
						<label>Email Address</label> <input type="email"
							class="form-control" name="customer-email" placeholder="Enter email"
							required />
					</div>

					<div class="form-group mb-3">
						<label>Password</label> <input type="password"
							class="form-control" name="customer-password"
							placeholder="Enter password" required />
					</div>

					<div class="form-group row mt-4">
						<div class="col text-center">
							<button type="submit" class="btn btn-primary">Login</button>
						</div>
						<div class="col text-center">
							<button type="submit" class="btn btn-secondary" name="action"
								value="cancel">Cancel</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


	<%@include file="includes/bootstrapjs.jsp"%>
</body>
</html>