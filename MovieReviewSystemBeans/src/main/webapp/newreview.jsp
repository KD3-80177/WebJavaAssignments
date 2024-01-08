<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="nrb" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Review</title>
</head>
<body>
	<jsp:useBean id="nr" class="com.sunbeam.beans.AddReview" />
	<jsp:setProperty property="*" name="nr"/>
	${nr.AddMyReview()}
	<jsp:forward page="ctl?page=review"/>
</body>
</html>