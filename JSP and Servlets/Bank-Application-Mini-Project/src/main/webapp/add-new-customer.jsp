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

	<div class="container mt-3">
		<nav class="navbar bg-secondary mt-3 p-4 border rounded">
			<div
				class="container-fluid d-flex justify-content-center align-items-center">
				<h1>Add New Customer</h1>
			</div>
		</nav>
		
		<c:if test="${not empty message}">
			<div class="alert alert-primary alert-dismissible fade show w-50 mx-auto my-3" role="alert">
				${message}
				<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>
		</c:if>
		
		<div class="card w-50 mx-auto my-5">
			<div class="card-body">
				<form action="admin-function" method="post">
					<input type="hidden" name="command" value="add-new-customer" />
					<div class="form-group mb-3">
						<label>First Name</label> <input type="text" class="form-control"
							name="customer-fname" placeholder="Enter First Name" required />
					</div>

					<div class="form-group mb-3">
						<label>Last Name</label> <input type="text" class="form-control"
							name="customer-lname" placeholder="Enter Last Name" required />
					</div>

					<div class="form-group mb-3">
						<label>Email Address</label> <input type="email"
							class="form-control" name="customer-email"
							placeholder="Enter email" required />
					</div>

					<div class="form-group mb-3">
						<label>Password</label> <input type="password"
							class="form-control" name="customer-password"
							placeholder="Enter password" required />
					</div>

					<div class="form-group row mt-4">
						<div class="col text-center">
							<button type="submit" class="btn btn-primary">Add</button>
						</div>
						<div class="col text-center">
							<button type="reset" class="btn btn-warning">Reset</button>
						</div>

					</div>
				</form>

				
			</div>
		</div>
		
		
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