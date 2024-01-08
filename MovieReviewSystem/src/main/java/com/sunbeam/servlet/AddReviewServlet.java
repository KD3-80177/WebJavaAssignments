package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.ReviewsDao;
import com.sunbeam.dao.ReviewsDaoInterface;
import com.sunbeam.pojo.ReviewPojo;
import com.sunbeam.pojo.UserPojo;

@WebServlet("/addreview")
public class AddReviewServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		UserPojo user = (UserPojo)session.getAttribute("curUser");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add Review</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method='post' action='addreview'>");
		out.println("Movie_ID: <input type='number' name='mid'/>\r\n<br/>");
		out.println("Review: <input type='text' name='review'/>\r\n<br/>");
		out.println("Rating: <input type='number' name='rating'/>\r\n<br/>");
		out.printf("User_ID: <input type='number' name='userid' value='%d' readonly/>\r\n<br/>",user.getId());
		out.println("<input type='submit' value='Add Review'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session = req.getSession();
			UserPojo user = (UserPojo)session.getAttribute("curUser");
			
			String mid = req.getParameter("mid");
			int movie_id = Integer.parseInt(mid);
			String review = req.getParameter("review");
			String rating = req.getParameter("rating");
			int rat = Integer.parseInt(rating);
			String uid = req.getParameter("userid");
			int user_id = Integer.parseInt(uid);
			ReviewPojo r = new ReviewPojo(movie_id,review,rat,user_id);
			int cnt = 0;
			try(ReviewsDaoInterface rev = new ReviewsDao()) {
				cnt = rev.addReview(r);
			} catch (Exception e) {
				throw new ServletException(e);
			}
			resp.sendRedirect("myreview");
	}
}
