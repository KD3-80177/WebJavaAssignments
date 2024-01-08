package com.sunbeam.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoInterface;
import com.sunbeam.pojo.UserPojo;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("passwd");
		System.out.println("**********");
		System.out.println("Email: "+email+" Password: "+password);
		try(UserDaoInterface userDao = new UserDao()){
			UserPojo user = userDao.findByEmail(email);
			System.out.println("Found user: "+user);
			if(user != null && user.getPassword().equals(password)){
				HttpSession session = req.getSession();
				session.setAttribute("curUser", user);
				
				String userName = user.getFname() + " " + user.getLname();
				Cookie c = new Cookie("uname",userName);
				resp.addCookie(c);
				resp.sendRedirect("review");
			}else {
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Login Failed</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h5>Invalid email or password</h5>");
				out.println("<a href='index.html'>Login Again</a>");
				out.println("</body>");
				out.println("</html>");
			}
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
}
