<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bank Info</title>
</head>
<body>
	<form action="bankinfo" method="post">
		<h1 align="center">Bank information</h1>
		Bank Name : <select name="bankname" id="bankname">
				    <option value="WellsFargo">Wells Fargo</option>
				    <option value="Chase">Chase</option>
				    <option value="CapitalOne">Capital One</option>
				    <option value="BankofMontreal">Bank of Montreal</option>
				    <option value="Citi">Citi</option>
				    <option value="Tangerine">Tangerine</option>			    
				  </select><br> <br>
		Account # : <input type="number" name="account"><br><br> 
		SSN : <input type="text" pattern="\d*" name = "ssn" maxlength="9"><br><br> 
		
		<br> <input type="submit" name="submit" value="Submit">
	</form>
</body>
</html>