<%@page import="com.codingtest.loanportal.LoginDAO"%>
<%@page import="com.codingtest.loanportal.EnquiryForm"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %> 

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Approver1</title>
</head>
<body>
<h1 align="center">Welcome Approver 1</h1>

<%
		LoginDAO ldo=new LoginDAO();
		List<EnquiryForm> enqForm=ldo.getEnquiry();
		
		for(EnquiryForm eq: enqForm)
		{
			out.println(eq.getCustomerName()+"<br>");
			
		}	

%>



</body>
</html>