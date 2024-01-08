<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
	<center>
	<form method="post" action="ctl?page=signup">
		First Name: <input type="text" name="firstName"/> <br><br>
		Last Name: <input type="text" name="lastName"/> <br><br>
		Email: <input type="text" name="userEmail"/> <br><br>
		Password: <input type="password" name="userPassword"/> <br><br>
		Mobile: <input type="number" name="userMobile"/> <br><br>
		Birth Date(dd-mm-yyyy): <input type="text" name="userBirthDate"/> <br><br>
		<input type="submit" value="Sign Up"/> <br><br>
	</form>
	</center>
</body>
</html>