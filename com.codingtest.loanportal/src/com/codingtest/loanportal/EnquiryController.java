package com.codingtest.loanportal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EnquiryController")
public class EnquiryController extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		
		
		  
		
		 int enqid= Integer.parseInt(request.getParameter("eqid"));
		 String name= request.getParameter("cname");
		 String job= request.getParameter("jobtype");
		 double amt= Double.parseDouble(request.getParameter("lamount"));
		 double interest=Double.parseDouble(request.getParameter("irate"));
		 
		LoginDAO ldo=new LoginDAO();
		ldo.createEnquiry(enqid, name,job,amt,interest);
		 
		  
		  
		  
		  if(interest > 14)
			  out.println("<h1 align='center'> Auto Approved");
		  else
			  out.println("Enquiry submitted succesfully!!! \n Your request is under process. ");
			
		}
	
}
