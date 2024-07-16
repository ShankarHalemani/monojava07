<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container mt-5">
		<h2 class="text-center">Student Form</h2>
		<hr>
		<form action="test" method="post">
			<div class="col-sm-10 mb-3">
				<label for="first_name" class="form-label">First Name</label> <input
					type="text" name="first_name" id="first_name" class="form-control">
			</div>

			<div class="col-sm-10 mb-3">
				<label for="last_name" class="form-label">Last Name</label> <input
					type="text" name="last_name" id="last_name" class="form-control">
			</div>

			<div class="mb-3">
				<label for="city">City</label> <select class="form-select"
					name="city" id="city" aria-label="Default select example">
					<option value="Mumbai">Mumbai</option>
					<option value="Bangalore">Bangalore</option>
					<option value="Belagavi">Belagavi</option>
				</select>
			</div>

			<div class="col-sm-10 mb-3">
				<label>Gender</label>

				<div class="form-check">
					<input class="form-check-input" value="Male" type="radio"
						name="gender" id="gender-male"> <label
						class="form-check-label" for="gender"> Male </label>
				</div>

				<div class="form-check">
					<input class="form-check-input" value="Female" type="radio"
						name="gender" id="gender-female" checked> <label
						class="form-check-label" for="gender"> Female </label>
				</div>

			</div>

			<div class="col-sm-10 mb-3">
				<label>Languages</label>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" name="language"
						value="Kannada" id="language-kannada"> <label
						class="form-check-label" for="language"> Kannada </label>
				</div>

				<div class="form-check">
					<input class="form-check-input" type="checkbox" name="language"
						value="English" id="language-english" checked> <label
						class="form-check-label" for="language"> English </label>
				</div>

				<div class="form-check">
					<input class="form-check-input" type="checkbox" name="language"
						value="Hindi" id="language-hindi" checked> <label
						class="form-check-label" for="language"> Hindi </label>
				</div>

				<div class="form-check">
					<input class="form-check-input" type="checkbox" name="language"
						value="Tamil" id="language-tamil" checked> <label
						class="form-check-label" for="language"> Tamil </label>
				</div>

			</div>

			<div class="col-sm-10 mb-3">
				<input type="submit" value="Submit" class="btn btn-primary">
			</div>
		</form>
	</div>
</body>
</html>