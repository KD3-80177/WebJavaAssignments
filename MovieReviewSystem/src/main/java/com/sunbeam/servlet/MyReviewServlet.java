package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.ReviewsDao;
import com.sunbeam.dao.ReviewsDaoInterface;
import com.sunbeam.pojo.ReviewPojo;
import com.sunbeam.pojo.UserPojo;

@WebServlet("/myreview")
public class MyReviewServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(ReviewsDaoInterface rev = new ReviewsDao()) {
			HttpSession session = req.getSession();
			UserPojo user = (UserPojo)session.getAttribute("curUser");
			List<ReviewPojo> list = rev.showResReviews(user.getId());
			
			String userName = user.getFname()+ " " +user.getLname();
			Cookie c = new Cookie("uname", userName);
			resp.addCookie(c);
			
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Home</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<center>");
			out.printf("Hello, %s<hr/>\r\n",userName);
			out.println("<a href='review'>All Reviews</a>    ");
			out.println("<a href='myreview'>My Reviews</a>   ");
			out.println("<a href='sharedreview'>Shared Reviews</a>    ");
			out.println("<hr/>");
			out.println("<h5>All Reviews</h5>");
			out.println("<table border='1'>");
			out.println("<thead>");
			out.println("<th>Review_ID</th>");
			out.println("<th>Moview</th>");
			out.println("<th>Review</th>");
			out.println("<th>rating</th>");
			out.println("<th>User_ID</th>");
			out.println("<th>Modified</th>");
			out.println("<th>Action</th>");
			out.println("</thead>");
			out.println("<tbody>");
			for(ReviewPojo r : list) {
				out.println("<tr>");
				out.printf("<td>%d</td>\r\n",r.getRev_id());
				out.printf("<td>%d</td>\r\n",r.getM_id());
				out.printf("<td>%s</td>\r\n",r.getReview());
				out.printf("<td>%d</td>\r\n",r.getRating());
				out.printf("<td>%d</td>\r\n",r.getUser_id());
				out.printf("<td>%s</td>\r\n",r.getMod_time());
				out.printf("<td><a href='revEdit?id=%d'><img src='edit.png' alt='Edit' width='24' height='24'/></a><a href='revDel?id=%d'><img src='delete.png' alt='delete' width='24' height='24'/></a></td>\r\n",r.getRev_id(),r.getRev_id());
				out.println("</tr>");
			}
			out.println("</tbody>");
			out.println("</table>");
			out.println("</table>");
			out.println("<hr/>");
			out.println("<a href='addreview'>Add Review</a>      ");
			out.println("<a href='sharereview'>Share Review</a>     ");
			out.println("<a href='signout'>Sign out</a>    ");
			out.println("</center>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
	}
}
