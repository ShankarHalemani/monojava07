<%@page import="com.techlabs.connection.DbCon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<%@include file="includes/bootstrapcss.jsp"%>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>
	<%out.println(DbCon.getConnection()); %>

	<%@include file="includes/bootstrapjs.jsp"%>
</body>
</html>