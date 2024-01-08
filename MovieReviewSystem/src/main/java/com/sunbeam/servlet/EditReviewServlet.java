package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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

@WebServlet("/revEdit")
public class EditReviewServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		UserPojo user = (UserPojo) session.getAttribute("curUser");
		
		String rv_id = req.getParameter("id");
		int rid = Integer.parseInt(rv_id);
		
		try(ReviewsDaoInterface rev = new ReviewsDao()){
			ReviewPojo r = rev.showMyReviews(rid);
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>EditReview</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<center>");
			out.println("<form method='post' action='revEdit'>");
			out.printf("Review_ID: <input type='number' name='rid' value='%d' readonly/>\r\n<br/>",r.getRev_id());
			out.printf("Movie_ID: <input type='number' name='mid' value='%d'readonly/>\r\n<br/>",r.getM_id());
			out.printf("Review: <input type='text' name='review' value='%s'/>\r\n<br/>",r.getReview());
			out.printf("Rating: <input type='number' name='rating' value='%d'/>\r\n<br/>",r.getRating());
			out.printf("User_ID: <input type='number' name='userid' value='%d' readonly/>\r\n<br/>",user.getId());
			out.println("<input type='submit' value='Add Review'/>");
			out.println("</form>");
			out.println("</center>");
			out.println("</body>");
			out.println("</html>");
		}catch(Exception e) {
			throw new ServletException(e);
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String rev_id = req.getParameter("rid");
		int rid = Integer.parseInt(rev_id);
		String r = req.getParameter("review");
		String rat = req.getParameter("rating");
		int rating = Integer.parseInt(rat);
		try(ReviewsDaoInterface rev = new ReviewsDao()){
			int cnt = rev.updateReview(rid,rating,r);
		}catch(Exception e) {
			throw new ServletException(e);
		}
		resp.sendRedirect("myreview");
	}
}
