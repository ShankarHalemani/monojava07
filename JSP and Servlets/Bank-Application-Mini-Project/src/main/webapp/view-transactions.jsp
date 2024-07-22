<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="includes/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Transactions</title>
<%@include file="includes/bootstrapcss.jsp"%>
</head>
<body>


	<div class="container">

		<nav class="navbar bg-secondary mt-3 border rounded">
			<div
				class="container-fluid d-flex justify-content-between align-items-center">
				<div class="d-flex flex-grow-1 justify-content-center p-4">
					<h1 class="mb-0">View Transactions</h1>
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
				class="alert alert-warning alert-dismissible fade show w-50 mx-auto my-3"
				role="alert">
				${message}
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>
		</c:if>

		<div class="row justify-content-center mt-3">
			<div class="col-lg-8">
				<form action="admin-function" method="post" class="row g-3">
					<input type="hidden" name="command" value="search-transaction" />
					<div class="col-md-4">
						<label for="initialDate"
							class="form-label d-flex justify-content-center">Start
							Date</label> <input type="date" class="form-control" id="initialDate"
							name="start-date" />
					</div>
					<div class="col-md-4">
						<label for="endDate"
							class="form-label d-flex justify-content-center">End Date</label>
						<input type="date" class="form-control" id="endDate"
							name="end-date" />
					</div>
					<div class="col-md-4">
						<label for="customerId"
							class="form-label d-flex justify-content-center">Account
							Number</label> <input type="text" class="form-control" id="accountNumber"
							placeholder="Enter Account Number" name="account-number" />
					</div>
					<div class="col-12 d-flex justify-content-center mt-3">
						<button type="submit" class="btn btn-primary">Search</button>
					</div>
				</form>
			</div>
		</div>

		<table class="table table-striped table-bordered mt-3">
			<thead>
				<tr>
					<th>Sender Account Number</th>
					<th>Receiver Account Number</th>
					<th>Type of Transaction</th>
					<th>Amount</th>
					<th>Date</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="transaction" items="${theTransactions}">
					<tr>
						<td>${transaction.senderAccountNumber}</td>
						<td>${transaction.receiverAccountNumber}</td>
						<td>${transaction.transactionType}</td>
						<td>${transaction.transactionAmount}</td>
						<td>${transaction.dateOfTransaction}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<form action="admin" method="get">
			<div class="form-group row my-4">
				<div class="col text-center">
					<button type="submit" name="admin-function" value=""
						class="btn btn-danger">Cancel</button>
				</div>
			</div>
		</form>
	</div>


	<%@include file="includes/bootstrapjs.jsp"%>
</body>
</html>