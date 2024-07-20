<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="includes/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Transaction</title>
<%@include file="includes/bootstrapcss.jsp"%>
</head>
<body>
	<div class="container mt-3">
		<div class="row justify-content-center">
			<div class="col-12">
				<div class="p-4 border bg-secondary text-center">
					<h1>New Transaction</h1>
				</div>
			</div>
		</div>
		<div class="row justify-content-center mt-3">
			<div class="col-lg-6">
				<div class="p-4 border bg-light text-center">
					<h2 class="mb-4">TRANSFER</h2>
					<!-- Added margin-bottom for more space -->
					<form>
						<div class="form-group mb-4">
							<!-- Added margin-bottom for more space -->
							<label for="accountNumber">Account Number</label> <input
								type="text" class="form-control" id="accountNumber"
								placeholder="Enter account number">
						</div>
						<div class="form-group mb-4">
							<!-- Added margin-bottom for more space -->
							<label for="amount">Amount</label> <input type="text"
								class="form-control" id="amount" placeholder="Enter amount">
						</div>
						<div class="form-group mt-4">
							<!-- Added margin-top for more space -->
							<button type="submit" class="btn btn-primary mr-2">Submit</button>
							<button type="reset" class="btn btn-secondary">Cancel</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>