package com.codingtest.loanportal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginValidate")
public class LoginValidate  extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	  PrintWriter out=response.getWriter();
	  
	  
	  String user=request.getParameter("uid");
	  String pwd=request.getParameter("pwd");
	  
	  LoginDAO ldo=new LoginDAO();
	  int  role=ldo.checkLogin(user, pwd);
	  
	  
	  if(role==1)
		  response.sendRedirect("EnquiryForm.jsp");
	  else if(role==2)
		  response.sendRedirect("ApproverReport1.jsp");
	  else
		  out.println("Incorrect Credentials!!!");
		  
		 
		 	
	}


}
