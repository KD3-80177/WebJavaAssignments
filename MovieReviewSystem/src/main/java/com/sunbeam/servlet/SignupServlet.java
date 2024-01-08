package com.sunbeam.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoInterface;
import com.sunbeam.pojo.UserPojo;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String password = req.getParameter("passwd");
		String mobile = req.getParameter("mobile");
		String birth = req.getParameter("bdate");
		System.out.println(fname+" "+lname+" "+email+" "+password+" "+mobile+" "+birth);
		UserPojo user = new UserPojo(fname,lname,email,password,mobile,birth);
		try(UserDaoInterface ud = new UserDao()){
			int cnt = ud.signUp(user);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ServletException(e);
		}
		resp.sendRedirect("index.html");
	}
}
