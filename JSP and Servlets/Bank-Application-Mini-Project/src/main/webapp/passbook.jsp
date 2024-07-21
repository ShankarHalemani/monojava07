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
		<div class="row justify-content-center">
			<div class="col-12">
				<div class="p-4 border bg-secondary text-center">
					<h1>Passbook</h1>
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
								<td>
									<c:choose>
										<c:when test="${transaction.senderAccountNumber == currentUserAccountNumber}">
											<span class="debit">Debit</span>
										</c:when>
										<c:otherwise>
											<span class="credit">Credit</span>
										</c:otherwise>
									</c:choose>
								</td>
								<td>
									<c:choose>
										<c:when test="${transaction.senderAccountNumber == currentUserAccountNumber}">
											<span class="debit">-${transaction.transactionAmount}</span>
										</c:when>
										<c:otherwise>
											<span class="credit">+${transaction.transactionAmount}</span>
										</c:otherwise>
									</c:choose>
								</td>
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
							<button type="submit" name="customer-function"
								value="" class="btn btn-danger">Cancel</button>
						</div>
					</div>
		</form>
	</div>
</body>
</html>
