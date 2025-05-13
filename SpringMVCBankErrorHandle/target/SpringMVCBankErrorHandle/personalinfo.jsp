<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<title>Personal Info</title>
<style>
<jsp:include page="/css/style.css"/>
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<h1 align="center">Personal information</h1>
	<form:form action = "/SpringMVCBankErrorHandle/personalinfo" method="post" modelAttribute = "personalinfo">
     First name : <form:input path="fname"/>
     <form:errors path = "fname" cssClass ="error"/>
     Last name : <form:input path="lname"/>
      <form:errors path = "lname" cssClass ="error"/>
     Middle name : <form:input path="mname"/>
     Gender : <form:input path="gender"/>
      <form:errors path = "gender" cssClass ="error"/>
   
	<br>
	<br> <input type="submit" name="submit" value="Submit">

	</form:form>
</body>
</html>
