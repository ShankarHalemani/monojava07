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
	String favLang = request.getParameter("fav-language");
	Cookie myCookie = new Cookie("FavoriteLanguage", favLang);

	myCookie.setMaxAge(60 * 10);
	response.addCookie(myCookie); //Setting cookie to browser
	%>

	<hr>

	<h4>We set your favorite language</h4>
	<a href="cookie-home.jsp">Check home page</a>

</body>
</html>