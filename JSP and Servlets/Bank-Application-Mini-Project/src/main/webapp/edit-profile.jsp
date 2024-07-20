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
		<div class="row justify-content-center">
			<div class="col-12">
				<div class="p-4 border bg-secondary text-center">
					<h1>Edit Profile</h1>
				</div>
			</div>
		</div>
		<div class="row justify-content-center mt-3">
			<div class="col-lg-6">
				<div class="p-4 border bg-light text-center">
					<form action="user-function" method="post">
					<input type="hidden" name="command" value="submit-profile" />
						<div class="form-group mb-4">
							<label for="accountNumber">First Name</label> <input type="text"
								class="form-control" id="accountNumber"
								placeholder="Enter First Name" name="c-fname">
						</div>
						<div class="form-group mb-4">
							<label for="amount">Last Name</label> <input type="text"
								class="form-control" id="amount" placeholder="Enter Last Name"
								name="c-lname">
						</div>
						<div class="form-group mb-4">
							<label for="password">Password</label> <input type="text"
								class="form-control" id="password" placeholder="Enter Password"
								name="c-password">
						</div>
						<div class="form-group row mt-4">
							<div class="col text-center">
								<button type="submit" class="btn btn-primary">Update</button>
							</div>
							<div class="col text-center">
								<button type="reset" class="btn btn-warning" name="command"
									value="cancel">Cancel</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>