<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
	<center>
	<% session.invalidate(); %>
	Thank You For Visiting. <br><br>
	<a href="ctl?page=index">Come Again</a>
	</center>
</body>
</html>