<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Personal Info</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
	<h1 align="center">Personal information</h1>

	<form:form action = "/SpringMVCBankErrorHandle/personalinfo" method="post" modelAttribute = "personalInfo">
     First name : <form:input path="fname"/><br><br>
  
     <form:errors path = "fname" cssClass ="error"/><br><br>
     Last name : <form:input path="lname"/><br><br>
      <form:errors path = "lname" cssClass ="error"/><br><br>
     Middle name : <form:input path="mname"/><br><br>
     Gender : <form:input path="gender"/><br><br>
      <form:errors path = "gender" cssClass ="error"/><br><br>
   
	<br>
	<br> <input type="submit" name="submit" value="Submit">

	</form:form>
</body>
</html>
