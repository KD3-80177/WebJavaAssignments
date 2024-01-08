package com.sunbeam.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.dao.ReviewsDao;
import com.sunbeam.dao.ReviewsDaoInterface;

@WebServlet("/revDel")
public class DeleteReviewServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(ReviewsDaoInterface rev = new ReviewsDao()) {
			int cnt = rev.deleteReview(Integer.parseInt(req.getParameter("id")));
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
		resp.sendRedirect("myreview");
	}
}
