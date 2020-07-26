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
	
	LoginDAO ldo=new LoginDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		HttpSession sess=request.getSession();
		
		
		if(sess.getAttribute("userName")==null)
			response.sendRedirect("index.jsp");
		
		
		
		//LoginDAO ldo=new LoginDAO();
			 
		if((sess.getAttribute("userRole").toString()).equals("1"))
		{	
			
			
			
			
			  int enqid= Integer.parseInt(request.getParameter("eqid"));
			  String name=request.getParameter("cname"); 
			  String job=request.getParameter("jobtype");
			  double amt=Double.parseDouble(request.getParameter("lamount"));
			 // String interest=request.getParameter("irate");
			  
			  if(ldo.getDuplicateEnquiry(enqid).isEmpty())
			  {
				
				  try
				  {
					  System.out.println(request.getParameter("irate"));
					   double interest=Double.parseDouble(request.getParameter("irate"));

						  if(interest > 14) 
						  { 
							  if(ldo.createEnquiry(enqid, name,job,amt,interest,"AUTOAPPROVED",0,0))
							  {
								  sess.setAttribute("enquirystatus", "1");
								  response.sendRedirect("EnquiryForm.jsp");
							  }
							  else
								  out.println("Some Problem Occured");
						  }
						  else 
						  {
							  
							  if(interest<=0)
							  {
								  sess.setAttribute("enquirystatus", "4");
								  response.sendRedirect("EnquiryForm.jsp");
							  }
							  else
							  {

								  if(ldo.createEnquiry(enqid, name,job,amt,interest,"PENDING",0,0))
								  {
									  sess.setAttribute("enquirystatus", "2");
									  response.sendRedirect("EnquiryForm.jsp");
								  }
								  else
									  out.println("Some Problem Occured");
								    
							  }
							  
						  }
						  
				
					   
				  }
				  
				  catch(Exception e)
				  {
					  System.out.println("exception to aagaya hi hai");
					  sess.setAttribute("enquirystatus", "5");
					  response.sendRedirect("EnquiryForm.jsp");
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
			
			//for modification of records
			if(request.getParameter("eqid")!=null)
				{
				   int eqid=Integer.parseInt(request.getParameter("eqid"));
				   String flag=request.getParameter("flag");
				   if(!ldo.updateEnquiry(eqid,flag))
					   out.println("Some Problem Occured");
				 }
			
			//View Reports
			
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
	



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	  PrintWriter out=response.getWriter();
	  
	  
	  String user=request.getParameter("uid");
	  String pwd=request.getParameter("pwd");
	  
	  //LoginDAO ldo=new LoginDAO();
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
