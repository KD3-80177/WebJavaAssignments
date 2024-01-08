<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Review</title>
</head>
<body>
	<center>
		<jsp:useBean id="fr" class="com.sunbeam.beans.FindReviewBean"/>
		<jsp:setProperty property="rev_id" name="fr" param="id"/>
		${fr.FindEditReview()}
		<form method="post" action="ctl?page=updatereview">
			<input type="hidden" name="rev_id" value="${fr.review.rev_id}"/><br><br>
			Rating: <input type="number" name="rat" value="${fr.review.rating }"/><br><br>
			Review: <input type="text" name="r" value="${fr.review.review }"/><br><br>
			<input type="submit" value="Edit Review"/>
		</form>
	</center>
</body>
</html>