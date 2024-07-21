<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="includes/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<%@include file="includes/bootstrapcss.jsp"%>
</head>
<body>

	<div class="container mt-3">
		<%@include file="includes/header.jsp"%>
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Login</div>
			<div class="card-body">
				<form action="login" method="post">
					<div class="form-group mb-3">
						<label>Email Address</label> <input type="email"
							class="form-control" name="login-email" placeholder="Enter email"
							required />
					</div>

					<div class="form-group mb-3">
						<label>Password</label> <input type="password"
							class="form-control" name="login-password"
							placeholder="Enter password" required />
					</div>

					<div class="form-group">
						<c:if test="${param.error != null}">
							<p style="color: red;">Invalid Email ID or password</p>
						</c:if>
					</div>

					<div class="form-group mb-3 text-center">
						<label>Login as:</label>
						<div class="form-check form-check-inline ms-3">
							<input class="form-check-input" type="radio" name="userRole"
								id="admin" value="Admin" required /> <label
								class="form-check-label" for="admin">Admin</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="userRole"
								id="user" value="User" required /> <label
								class="form-check-label" for="user">User</label>
						</div>
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