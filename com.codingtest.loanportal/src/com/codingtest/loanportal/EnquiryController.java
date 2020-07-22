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
			
			
			
			
			  int enqid= Integer.parseInt(request.getParameter("eqid"));
			  String name=request.getParameter("cname"); 
			  String job=request.getParameter("jobtype");
			  double amt=Double.parseDouble(request.getParameter("lamount"));
			  double interest=Double.parseDouble(request.getParameter("irate"));
			  
			  if(ldo.getDuplicateEnquiry(enqid).isEmpty())
			  {
				  
				  if(interest > 14) 
				  { 
					  if(ldo.createEnquiry(enqid, name,job,amt,interest,"AUTOAPPROVED"))
					  {
						  sess.setAttribute("enquirystatus", "1");
						  response.sendRedirect("EnquiryForm.jsp");
					  }
					  else
						  out.println("Some Problem Occured");
				  }
				  else 
				  {
					  if(ldo.createEnquiry(enqid, name,job,amt,interest,"PENDING"))
					  {
						  sess.setAttribute("enquirystatus", "2");
						  response.sendRedirect("EnquiryForm.jsp");
					  }
					  else
						  out.println("Some Problem Occured");
					  
				  }
				  
				  
				  
			  }
			  
			  else
			  {
				  sess.setAttribute("enquirystatus", "3");
				  response.sendRedirect("EnquiryForm.jsp");
			  }
			   
			  
		} 
		else
		{
		
			String role=sess.getAttribute("userRole").toString();
			
			List<EnquiryForm> enqForm=ldo.getEnquiry(role);
			
			
			
			sess.setAttribute("enquiryFetch", enqForm);
			
			if(role.equals("2"))
				response.sendRedirect("ApproverReport2.jsp");
			else if (role.equals("3"))
				response.sendRedirect("ApproverReport3.jsp");
			else
				response.sendRedirect("ApproverReport4.jsp");

		}
		 			
			
			
		}
	
}
