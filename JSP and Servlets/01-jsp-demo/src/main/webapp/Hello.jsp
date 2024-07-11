<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Expression Tag  -->
	<h1>Hello World</h1>
	<br>
	Todays date is <%= new java.util.Date() %>
	<br>
	Sum of 10 and 20 is  <%= 10+20 %>
	<br>
	10 greater than 20 is : <%=10>20 %>
	<br>
	String caps : <%= new String("Hello World").toUpperCase() %>
	<br>
	
	<!-- Scriplet tags  -->
	<%
	
	for(int i=0; i<10; i++){
		out.println("<h4>Number "+i+"<h4>");
	}
	
	%>

	<!-- Declaration Tags -->
	<%!
	String convertToUpperCase(String str){
		return str.toUpperCase();
	}
	%>
	
	<%=convertToUpperCase("India Is my country") %>
	
	<%!
	public String convertFirstLetterOfWordToUpperCase(String str) {
	    if (str == null || str.isEmpty()) {
	        return str;
	    }

	    StringBuilder result = new StringBuilder();
	    String[] words = str.split(" ");
	    
	    for (String word : words) {
	        if (word.length() > 0) {
	            result.append(Character.toUpperCase(word.charAt(0)))
	                  .append(word.substring(1))
	                  .append(" ");
	        }
	    }

	    // Remove the trailing space
	    return result.toString().trim();
	}

	%>
	
	<%=convertFirstLetterOfWordToUpperCase("India Is my country") %>
	

</body>
</html>