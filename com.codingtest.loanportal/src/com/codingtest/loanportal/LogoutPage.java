package com.codingtest.loanportal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutPage")
public class LogoutPage extends HttpServlet{

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		PrintWriter out=res.getWriter();
		
		HttpSession session=req.getSession();
		
		session.removeAttribute("userName");
		session.removeAttribute("userRole");
		
		session.invalidate();
		
		res.sendRedirect("index.jsp");
		
	}
	
}
