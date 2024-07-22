<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="includes/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>
<%@include file="includes/bootstrapcss.jsp"%>
</head>
<body>
	<div class="container mt-3">
		<nav class="navbar bg-secondary mt-3 border rounded">
			<div
				class="container-fluid d-flex justify-content-between align-items-center">
				<div class="d-flex flex-grow-1 justify-content-center p-4">
					<h1 class="mb-0">Edit Profile</h1>
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

		<c:if test="${not empty message}">
			<div
				class="alert alert-primary alert-dismissible fade show w-50 mx-auto my-3"
				role="alert">
				${message}
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>
		</c:if>

		<div class="row justify-content-center mt-3">
			<div class="col-lg-6">
				<div class="p-4 border bg-light text-center">
					<form action="user-function" method="post">
						<input type="hidden" name="command" value="submit-profile" />
						<div class="form-group mb-4">
							<label for="firstName">First Name</label> <input type="text"
								class="form-control" id="firstName"
								placeholder="Enter First Name" name="c-fname">
						</div>
						<div class="form-group mb-4">
							<label for="lastName">Last Name</label> <input type="text"
								class="form-control" id="lastName" placeholder="Enter Last Name"
								name="c-lname">
						</div>
						<div class="form-group mb-4">
							<label for="password">Password</label> <input type="password"
								class="form-control" id="password" placeholder="Enter Password"
								name="c-password">
						</div>
						<div class="form-group row mt-4">
							<div class="col text-center">
								<button type="submit" class="btn btn-primary">Update</button>
							</div>
							<div class="col text-center">
								<button type="reset" class="btn btn-warning" name="command"
									value="cancel">Reset</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

		<form action="user" method="get">
			<div class="form-group row mt-4">
				<div class="col text-center">
					<button type="submit" name="customer-function" value=""
						class="btn btn-danger">Cancel</button>
				</div>
			</div>
		</form>
	</div>

	<%@include file="includes/bootstrapjs.jsp"%>
</body>
</html>
