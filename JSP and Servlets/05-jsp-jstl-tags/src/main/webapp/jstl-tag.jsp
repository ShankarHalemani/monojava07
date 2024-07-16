<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:set var="name" value="Shankar"></c:set>
	<h1>Welcome ${name}</h1>

	<c:if test="${name.length()>=5 }">

		<h2>Name : ${name} is 5 or more characters long</h2>

	</c:if>

	<c:if test="${name.length()<5 }">

		<h2>Name : ${name} is less than 5 characters long</h2>

	</c:if>

	<c:choose>

		<c:when test="${name.equals('Ajay') }">
			Your name is Ajay
	</c:when>
		<c:when test="${name.equals('Shankar') }">
			Your name is Shankar
	</c:when>
		<c:otherwise>
			I don't know your name
	</c:otherwise>

	</c:choose>

</body>
</html>