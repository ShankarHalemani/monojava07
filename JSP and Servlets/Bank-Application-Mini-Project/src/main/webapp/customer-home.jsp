<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="includes/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Home</title>
<%@include file="includes/bootstrapcss.jsp"%>
</head>
<body>
	<div class="container mt-3">

		<nav class="navbar bg-secondary border rounded p-4">
			<div
				class="container-fluid d-flex justify-content-center align-items-center">
				<h1>Customer Home</h1>
			</div>
		</nav>

		<nav
			class="navbar navbar-expand-lg navbar-light bg-light mt-3 px-5 border rounded">
			<form action="user" method="get" class="w-100">
				<div class="d-flex justify-content-around">
					<input type="submit" name="customer-function" value="Passbook"
						class="navbar-brand nav-link mx-2" /> <input type="submit"
						name="customer-function" value="New Transaction"
						class="navbar-brand nav-link mx-2" /> <input type="submit"
						name="customer-function" value="Edit Profile"
						class="navbar-brand nav-link mx-2" />
				</div>
			</form>
		</nav>

		<div class="text-center mt-4">
			<img src="./includes/bank.jpeg" class="rounded img-fluid"
				alt="Bank-image" width="70%" />
		</div>

	</div>

	<%@include file="includes/bootstrapjs.jsp"%>
</body>
</html>
