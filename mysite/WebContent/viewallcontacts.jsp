<%@page import="assign.dbaccess.EMailAddressVOO"%>
<%@page import="java.util.ArrayList"%>
<%@include file="header.html"%>
<html>
<head>
<title>View All Contacts</title>
</head>

<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">

	<center>
		<%@include file="displayformerrors.jsp"%>
		<h2>View All Contacts</h2>
	</center>
	<!--Body: add contact information-->
	<center>
		<form method="post">
			<%
			ArrayList<EMailAddressVOO> emailList = (ArrayList<EMailAddressVOO>) session.getAttribute("emailList");
			%>
			<table border=1>
				<tr>
					<th>First name</th>
					<th>Middle name</th>
					<th>Last name</th>
					<th>Email</th>
					<th>Home phone</th>
					<th>Work phone</th>
					<th>Mobile</th>
					<th>Group ID</th>
				</tr>
				<%
				for (EMailAddressVOO email : emailList) {
				%>
				<tr>
					<td><%=email.getfName()%></td>
					<td><%=email.getmName()%></td>
					<td><%=email.getlName()%></td>
					<td><%=email.geteMailID()%></td>
					<td><%=email.gethPhone()%></td>
					<td><%=email.getwPhone()%></td>
					<td><%=email.getmPhone()%></td>
					<td><%=email.getgroupID()%></td>
				</tr>
				<%
				}
				%>

			</table>
		</form>
	</center>
</body>

</html>
<%@include file="footer.html"%>

</body>