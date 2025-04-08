<%@include file="header.html"%>
<html>
<head>
<title>Logout Page</title>
</head>

<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">

	<center>
		<h2>Logout</h2>
	</center>

	<center>
</body>

<%
session.invalidate();
%>

</html>
<%@include file="footer.html"%>

</body>