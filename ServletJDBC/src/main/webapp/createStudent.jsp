<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Studentjdbc" method=post>
		First name : <input type="text" name="fname" /><br>
		<br> Last name : <input type="text" name="lname" /><br>
		<br> Age : <input type="text" name="age" /><br>
		<br> Email : <input type="text" name="email" /><br>
		<br> Gender : <input type="radio" name="gender" value="male" />
		Male <input type="radio" name="gender" value="female" /> Female <br>
		<br> <input type="submit" name="register_button" value = "Register"/>
	</form>
</body>
</html>