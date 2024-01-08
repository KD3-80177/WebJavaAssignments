<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Review</title>
</head>
<body>
	<jsp:useBean id="ur" class="com.sunbeam.beans.UpdateReviewBean"/>
	<jsp:setProperty property="rev_id" name="ur" param="rev_id"/>
	<jsp:setProperty property="rat" name="ur" param="rat"/>
	<jsp:setProperty property="rev" name="ur" param="r"/>
	${ur.UpdateMyReview()}
	<jsp:forward page="ctl?pagereview"></jsp:forward>
</body>
</html>