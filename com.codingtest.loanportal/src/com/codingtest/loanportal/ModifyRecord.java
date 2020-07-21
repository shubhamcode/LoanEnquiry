package com.codingtest.loanportal;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codingtest.loanportal.LoginDAO;

@WebServlet("/ModifyRecord")
public class ModifyRecord extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		
		HttpSession sess=request.getSession();
		
			if(sess.getAttribute("userName")==null)
					response.sendRedirect("index.jsp");
		
		int eqid=Integer.parseInt(request.getParameter("eqid"));
		String flag=request.getParameter("flag");
		
		
		
		  LoginDAO ldo=new LoginDAO(); 
		  if(ldo.updateEnquiry(eqid,flag))
			  response.sendRedirect("EnquiryController"); 
		  else out.println("Fataaaaa");
		 
	
	}

}
