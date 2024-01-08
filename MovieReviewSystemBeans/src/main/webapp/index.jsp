<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<center>
	<form action="ctl?page=login" method="post">
		Email: <input type="text" name="email"/><br><br>
		Password: <input type="password" name="passwd"/><br><br>
		<input type="submit" value="Log In"/>
		<a href="ctl?page=registration">Sign Up</a>
	</form>
	</center>
</body>
</html>