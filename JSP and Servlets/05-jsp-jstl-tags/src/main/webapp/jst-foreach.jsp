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

	<%
	String[] degrees = { "B.E", "BSC", "BCom", "BMS", "BAMS" };
	pageContext.setAttribute("theDegrees", degrees);
	/* for(String degree : degrees){
		out.println(degree);
	} */
	%>

	<c:forEach var="degree" items="${theDegrees}">
	
	${degree}<br>
	
	</c:forEach>

</body>
</html>