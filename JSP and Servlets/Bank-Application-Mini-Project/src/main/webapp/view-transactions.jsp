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

		<nav class="navbar bg-secondary rounded border p-4 mt-3">
			<div
				class="container-fluid d-flex justify-content-center align-items-center">
				<h1 >View Transactions</h1>
			</div>
		</nav>
		
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