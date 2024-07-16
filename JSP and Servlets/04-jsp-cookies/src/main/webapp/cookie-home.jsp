<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String favoritelanguage = "Java";
	Cookie[] cookies = request.getCookies();

	if (cookies != null) {
		for (Cookie c : cookies) {
			if (c.getName().equals("FavoriteLanguage")) {
				favoritelanguage = c.getValue();
				break;
			}
		}
	}
	%>

	<h2>
		Your preferred language is
		<%=favoritelanguage%></h2>
	<a href="cookieform.jsp">Change your favorite language</a>
	
</body>
</html>