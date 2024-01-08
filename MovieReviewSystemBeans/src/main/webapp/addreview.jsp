<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Review</title>
</head>
<body>
	<center>
		<form method="post" action="ctl?page=newreview">
			Movie_ID: <input type="number" name="mid"/> <br><br>
			Review: <input type="text" name="mrev"/> <br><br>
			Rating: <input type="number" name="mrat"/> <br><br>
			<input type="hidden" name="userID" value="${lb.user.id}"/> <br><br>
			<input type="submit" value="Add Review"/> <br><br>
		</form>
	</center>
</body>
</html>