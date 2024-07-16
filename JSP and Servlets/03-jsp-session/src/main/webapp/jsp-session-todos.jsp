<%@page import="com.techlabs.model.StringUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<div class="container">
        <h2 class="text-center">Todos</h2>

        <form action="jsp-session-todos.jsp" method="get">
            <div class="col-sm-10 mb-3">
                <input type="text" name="item" id="todo" class="form-control" placeholder="Enter a Todo">
            </div>

            <div class="col-sm-10 mb-3">
                <input type="submit" value="Add Todo" class="btn btn-dark">
            </div>
        </form>
        <hr>
        
        <ul class="list-group">
        
        <%
        
			List<String> todoItemList = (List<String>)session.getAttribute("sessionTodoItems");
	        
	        if(todoItemList==null){
	        	todoItemList = new ArrayList<String>();
	        	session.setAttribute("sessionTodoItems", todoItemList);
	        }
	        
	        String todoItem = request.getParameter("item");
	        if(!todoItem.trim().equals("") && !todoItemList.contains(todoItem)){
	        	todoItemList.add(todoItem);
	        }
	        
	        for(String item : todoItemList){
	        	out.println("<li class=\"list-group-item\">"+item+"</li>");
	        }
        
        %>
        
        </ul>
        
        <div class="mt-5">
        
        <%
        
        String concatString = StringUtil.concatString("Shankar", " Halemani");
        out.println("Concatinated String "+concatString);
        
        %>
        
        </div>
        

    </div>
</html>