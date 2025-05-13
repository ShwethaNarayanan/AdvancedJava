<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import = "jakarta.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
</head>
<body>
  <form action = "userLogin" method="post" >  
		<br> <br>
		<h2 style = "color:blue ; text-align: center">Login</h2>
		 User name : <input type = "text" name = "username"><br>
		<br>
		 Password : <input type = "password" name = "password" >
		<br>
		<br>
		<input type = "submit" name = "login" value = "Login">

</form>
</body>
</html>