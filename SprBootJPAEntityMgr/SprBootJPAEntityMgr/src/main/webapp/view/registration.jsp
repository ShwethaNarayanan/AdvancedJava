<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
</head>
<body>
	<form action="register" method="post">
		<h1 align="center">Student information</h1>
		<br>
		<br>
		<% if (request.getAttribute("message") != null) 
		     out.println(request.getAttribute("message")) ; 
		       %>
		First name : <input type="text" name="fname"><br>
		<br> Last name : <input type="text" name="lname"><br>
		<br> Age : <input type="text" name="age"><br>
		<br> Email : <input type="text" name="email"><br>
		<br> Gender : <input type="radio" name="gender" value="Male">
		Male <input type="radio" name="gender" value="Female"> Female<br>
		<br> <input type="submit" name="submit" value="Register">
	</form>
</body>
</html>