package com.codingtest.loanportal;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EnquiryController")
public class EnquiryController extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		HttpSession sess=request.getSession();
		
		
		if(sess.getAttribute("userName")==null)
			response.sendRedirect("index.jsp");
		
		
		
		
		LoginDAO ldo=new LoginDAO();
			 
		if((sess.getAttribute("userRole").toString()).equals("1"))
		{	
			
			
			  System.out.println("yaha to aaya enqid-"+request.getParameter("eqid")); 
			  int enqid= Integer.parseInt(request.getParameter("eqid"));
			  String name=request.getParameter("cname"); 
			  String job=request.getParameter("jobtype");
			  double amt=Double.parseDouble(request.getParameter("lamount"));
			  double interest=Double.parseDouble(request.getParameter("irate"));
			  
			  
			  
			  if(interest > 14) 
			  { 
				  ldo.createEnquiry(enqid, name,job,amt,interest,"AUTOAPPROVED");
				  out.println("<h1 align='center'> Auto Approved"); 
			  }
			  else 
			  {
				  ldo.createEnquiry(enqid, name,job,amt,interest,"PENDING");
				  out.println("Enquiry submitted succesfully!!! \n Your request is under process. ");
			      
			  }
		} 
		else
		{
			
			List<EnquiryForm> enqForm=ldo.getEnquiry();
			
			
			
			sess.setAttribute("enquiryFetch", enqForm);
			
			response.sendRedirect("ApproverReport1.jsp");
			
		}
		 			
			
			
		}
	
}
