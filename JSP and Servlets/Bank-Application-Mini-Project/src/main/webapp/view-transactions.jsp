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
	<%@include file="includes/header.jsp"%>
	<hr />

	<nav class="navbar bg-body-tertiary">
		<div
			class="container-fluid d-flex justify-content-center align-items-center">
			<h1 class="navbar-brand my-2 py-2">View Transactions</h1>
		</div>
	</nav>

	<hr />

	<div class="container my-5">
		<table class="table table-striped">
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
				<c:forEach var="customer" items="${theCustomersList}">
					<tr>
						<td>${customer.SaccountNumber}</td>
						<td>${customer.RaccountNumber}</td>
						<td>${customer.transactionType}</td>
						<td>${customer.amount}</td>
						<td>${customer.date}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


	<%@include file="includes/bootstrapjs.jsp"%>
</body>
</html>