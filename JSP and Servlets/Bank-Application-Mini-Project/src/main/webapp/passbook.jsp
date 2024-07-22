<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="includes/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Passbook</title>
<%@include file="includes/bootstrapcss.jsp"%>
<style>
.credit {
	color: green;
}

.debit {
	color: red;
}
</style>
</head>
<body>
	<div class="container mt-3">


		<nav class="navbar bg-secondary mt-3 border rounded">
			<div
				class="container-fluid d-flex justify-content-between align-items-center">
				<div class="d-flex flex-grow-1 justify-content-center p-4">
					<h1 class="mb-0">Passbook</h1>
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

		<div class="row justify-content-center">
			<div class="col-12">

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
								<td><c:choose>
										<c:when
											test="${transaction.senderAccountNumber == currentUserAccountNumber}">
											<span class="debit">Debit</span>
										</c:when>
										<c:otherwise>
											<span class="credit">Credit</span>
										</c:otherwise>
									</c:choose></td>
								<td><c:choose>
										<c:when
											test="${transaction.senderAccountNumber == currentUserAccountNumber}">
											<span class="debit">-${transaction.transactionAmount}</span>
										</c:when>
										<c:otherwise>
											<span class="credit">+${transaction.transactionAmount}</span>
										</c:otherwise>
									</c:choose></td>
								<td>${transaction.dateOfTransaction}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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
</body>
</html>
