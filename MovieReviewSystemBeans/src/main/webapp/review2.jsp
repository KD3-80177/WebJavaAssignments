<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<title>Insert title here</title>
<link rel="stylesheet" href="index.css">
</head>
<body>
	<div class="login-container">
  		<form class="login-form" action="ctl?page=login" method="post">
    	<h2>Login</h2>
    	<div class="input-group">
      		<label for="email">Email</label>
      		<input type="email" id="email" name="email" placeholder="Your email">
    	</div>
    	<div class="input-group">
      		<label for="password">Password</label>
     		<input type="password" id="password" name="password" placeholder="Your password">
    	</div>
    	<button type="submit">Login</button>
    	<hr>
    	<label for="Sign Up">Create a new account</label> <br>
    	<button type="submit" onclick="redirectToRegistration()">Sign Up</button>
  		</form>
	</div>
	<script type="text/javascript">
		function redirectToRegistration(){
			window.location.href="ctl?page=registration";
		}
	</script>
</body>
</html>