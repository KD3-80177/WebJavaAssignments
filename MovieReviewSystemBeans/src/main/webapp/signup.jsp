<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
</head>
<body>
	<jsp:useBean id="sp" class="com.sunbeam.beans.SignUpBean"/>
	<jsp:setProperty property="fname" name="sp" param="firstName"/>
	<jsp:setProperty property="lname" name="sp" param="lasstName"/>
	<jsp:setProperty property="email" name="sp" param="userEmail"/>
	<jsp:setProperty property="password" name="sp" param="userPassword"/>
	<jsp:setProperty property="mobile" name="sp" param="userMobile"/>
	<jsp:setProperty property="bdate" name="sp" param="userBirthDate"/>
	<jsp:setProperty property="status" name="sp" value="false"/>
	<% sp.addUser(); %>
	<%
		if(sp.getStatus()){
			out.println("User Added Succesfully");
			out.println("<a href='ctl?page=index'>Click to Login</a>");
		}else{
			out.println("User not added");
		}
	%>
</body>
</html>