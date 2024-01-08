package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ctl")
public class FrontController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page=req.getParameter("page");
		String jspPath="";
		
		if(page.equals("index"))
			jspPath = "/index.jsp";
		else if(page.equals("login"))
			jspPath = "/login.jsp";
		else if(page.equals("review"))
			jspPath = "/review.jsp";
		else if(page.equals("myreview"))
			jspPath = "/myreview.jsp";
		else if(page.equals("registration"))
			jspPath = "/registration.jsp";
		else if(page.equals("addreview"))
			jspPath = "/addreview.jsp";
		else if(page.equals("delRev"))
			jspPath = "/delRev.jsp";
		else if(page.equals("editRev"))
			jspPath = "/editRev.jsp";
		else if(page.equals("logout"))
			jspPath = "/logout.jsp";
		else if(page.equals("newreview"))
			jspPath = "/newreview.jsp";
		else if(page.equals("signup"))
			jspPath = "/signup.jsp";
		else if(page.equals("updatereview"))
			jspPath = "/updatereview.jsp";
		else
			jspPath = "/notfound.jsp";
		
		ServletContext ctx = this.getServletContext();
		RequestDispatcher rd = ctx.getRequestDispatcher(jspPath);
		rd.forward(req, resp);
	}
}
