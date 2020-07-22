package com.codingtest.loanportal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginValidate")
public class LoginValidate  extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	  PrintWriter out=response.getWriter();
	  
	  
	  String user=request.getParameter("uid");
	  String pwd=request.getParameter("pwd");
	  
	  LoginDAO ldo=new LoginDAO();
	  int  role=ldo.checkLogin(user, pwd);
	  
	  HttpSession ses=request.getSession();
	  
	  if(role==1)
	  {
		  ses.setAttribute("userName", user);
		  ses.setAttribute("userRole", role);
		  
		  response.sendRedirect("EnquiryForm.jsp");
	  } 
		  
	else if(role==2 || role==3 || role==4)
	  {
		  
		  ses.setAttribute("userName", user);
		  ses.setAttribute("userRole", role);
		  
		  response.sendRedirect("EnquiryController");
		  
	  }
	  
	  
	else
	{
		ses.setAttribute("statusmgs","Not a Valid User");
		response.sendRedirect("index.jsp");
		  
	}	 
		 	
	}


}
