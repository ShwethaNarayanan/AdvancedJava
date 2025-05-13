<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import = "jakarta.servlet.*" %> 
	<%@ page import = "com.learn.beans.User" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>

	<h1> Welcome <%= request.getAttribute("fname") %> <%= request.getAttribute("lname") %></h1>
</body>
</html>