<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="arb" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<title>Review</title>
<style type="text/css">
	.table-container{
		text-align: center;
	}
	.table-container table {
  		margin: 0 auto; /* Centers the table within its container */
	}
</style>
</head>
	<body>
		<center>
			Hello, ${lb.user.fname} ${lb.user.lname}
			<hr class="border border-danger border-2 opacity-50">
			<p class="fw-semibold">Movie Review System</p>
			<hr class="border border-danger border-2 opacity-50">
			<br>
			<button type="button" class="btn btn-outline-primary" onclick="redirectToAll()">All Reviews</button>
			<button type="button" class="btn btn-outline-secondary" onclick="redirectToMy()">My Reviews</button>
			<button type="button" class="btn btn-outline-success" onclick="redirectToShared()">Shared Reviews</button>
			<br>
			<br>
			<h2>All Reviews</h2>
			<br>
			<br>
			<jsp:useBean id="arb" class="com.sunbeam.beans.AllReviewBean" />
			${arb.fetchAllRecords()}
			<div class="table-container">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Review_ID</th>
							<th>Movie_ID</th>
							<th>Review</th>
							<th>Rating</th>
							<th>User_ID</th>
							<th>Modified</th>
						</tr>
					</thead>
					<tbody>
						<arb:forEach var="reviews" items="${arb.allRevList}">
						<tr>
							<td>${reviews.rev_id }</td>
							<td>${reviews.m_id }</td>
							<td>${reviews.review }</td>
							<td>${reviews.rating }</td>
							<td>${reviews.user_id }</td>
							<td>${reviews.mod_time }</td>
						</tr>
						</arb:forEach>
					</tbody>
				</table>
			</div>
			<br>
			<hr>
			<button type="button" class="btn btn-outline-primary" onclick="redirectToAdd()">Add Review</button>
			<button type="button" class="btn btn-outline-secondary" onclick="redirectToShare()">Share Review</button>
			<button type="button" class="btn btn-outline-success" onclick="redirectToLogOut()">LogOut</button>
			<hr>
		</center>
		<script type="text/javascript">
			function redirectToAll() {
		  		window.location.href = 'ctl?page=review';
			}
			function redirectToMy() {
		  		window.location.href = 'ctl?page=myreview';
			}
			function redirectToShared() {
		  		window.location.href = 'ctl?page=sharedreview';
			}
			function redirectToAdd() {
		  		window.location.href = 'ctl?page=addreview&id=${lb.user.id}';
			}
			function redirectToShare() {
		  		window.location.href = 'ctl?page=sharereview';
			}
			function redirectToLogOut() {
		  		window.location.href = 'ctl?page=logout';
			}
			
		</script>
	</body>
</html>