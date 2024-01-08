<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Review</title>
</head>
<body>
	<jsp:useBean id="db" class="com.sunbeam.beans.DeleteReviewBean" />
	<jsp:setProperty property="review_id" name="db" param="id"/>
	${db.deleteReview()}
	<jsp:forward page="ctl?page=review"/>
</body>
</html>