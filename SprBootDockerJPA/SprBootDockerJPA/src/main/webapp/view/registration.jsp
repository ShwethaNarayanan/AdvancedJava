<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
</head>
<body>
	<form action="register" method = "post">
	<h1 align = "center">User information</h1><br><br>
	<% if (request.getAttribute("message") != null) 
		     out.println(request.getAttribute("message")) ; 
		       %>
	Name       : <input type = "text" name = "name"><br><br>
	Email      : <input type = "text" name = "email"><br><br>
		
	<input type = "submit" name = "submit" value = "Register">
	</form>
</body>
</html>