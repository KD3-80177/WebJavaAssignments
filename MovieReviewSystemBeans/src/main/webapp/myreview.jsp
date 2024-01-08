<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="mrb" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<style type="text/css">
	.table-container{
		text-align: center;
	}
	.table-container table {
  		margin: 0 auto; /* Centers the table within its container */
	}
</style>
<meta charset="ISO-8859-1">
<title>Review</title>
</head>
<body>
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
			<h2>My Reviews</h2>
			<br>
			<br>
			<jsp:useBean id="mr" class="com.sunbeam.beans.MyReviewBean"/>
			<jsp:setProperty property="userId" name="mr" value="${lb.user.id}"/>
			${mr.fetchMyReview()}
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
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<mrb:forEach var="myreview" items="${mr.myRevList}">
						<tr>
							<td>${myreview.rev_id }</td>
							<td>${myreview.m_id }</td>
							<td>${myreview.review }</td>
							<td>${myreview.rating }</td>
							<td>${myreview.user_id }</td>
							<td>${myreview.mod_time }</td>
							<td>
								<button type="button" class="btn btn-outline-warning" onclick="redirectToEdit()">Edit</button>
								<button type="button" class="btn btn-outline-danger" onclick="redirectToDelete()">Delete</button>
							</td>
						</tr>
					</mrb:forEach>
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
			function redirectToEdit() {
		  		window.location.href = 'ctl?page=editRev&id=${myreview.rev_id }';
			}
			function redirectToDelete() {
		  		window.location.href = 'ctl?page=delRev&id=${myreview.rev_id }';
			}
		</script>
</body>
</html>