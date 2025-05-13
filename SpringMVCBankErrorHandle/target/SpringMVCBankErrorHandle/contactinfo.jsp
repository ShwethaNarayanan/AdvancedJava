<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Contact Info</title>
</head>
<body>
	<form action="contactinfo" method="post">
		<% if (request.getAttribute("error") != null) 
		     out.println(request.getAttribute("error")) ; 
		       %>
		<h1 align="center">Contact information</h1>
		Address : <input type="text" name="address"><br><br>
		City : <input type="text" name="city"><br><br> 
		State : <input type="text" name="state"><br><br> 
		Country : <select name="country" id="country">
				    <option value="US">United States</option>
				    <option value="IN">India</option>
				    <option value="CA">Canada</option>
				    <option value="UK">United Kingdom</option>
				    <option value="AUS">Australia</option>
				    <option value="NZ">New Zealand</option>
				    <option value="DE">Germany</option>
				    <option value="SE">Sweden</option>
				    <option value="DK">Denmark</option>				    
				  </select><br> <br>
		Phone: <input type="text" pattern="\d*" name = "phone" maxlength="10"><br><br> 
		<br> <input type="submit" name="submit" value="Submit">
	</form>
</body>
</html>