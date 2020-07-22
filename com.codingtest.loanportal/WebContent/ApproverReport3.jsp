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
 <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
 


<title>Approver3</title>
<% 
  	HttpSession sess=request.getSession();
	if(sess.getAttribute("userName")==null)
		response.sendRedirect("index.jsp");
%>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12"><h1 align="center">Welcome Approver 3</h1></div>
	</div>
	<div class="row">
		<div class="col-sm-11"></div>
		<form action="LogoutPage">
		<div class="col-sm-1"><button type="submit" class="btn btn-group-lg btn-primary">Logout</button></div>
		</form>
	</div>
	
	
	<table class="table table-hover">
    <thead>
      <tr>
        <th>Enquiry Id</th>
		<th>Customer Name</th>
		<th>Job Type</th>
		<th>Loan Amount</th>
		<th>Interest Rate</th>
		<th>Status</th>
		<th></th>
      </tr>
    </thead>
    <tbody>
	<c:forEach items="${enquiryFetch}" var="enquiry">

<c:choose>
<c:when test="${enquiry.loanStatus=='APPROVED' or enquiry.loanStatus=='PENDING-3'}">
		<tr class="active">
        	<td>${enquiry.enquiryId}</td>
			<td>${enquiry.customerName}</td>
			<td>${enquiry.jobType}</td>
			<td>${enquiry.loanAmount}</td>
			<td>${enquiry.interestRate}</td>
			<td>${enquiry.loanStatus}</td>
			<td></td>
        
      	</tr>
</c:when>
<c:when test="${enquiry.interestRate<=13 and enquiry.interestRate>12}">
		<tr class="danger">
        	<td>${enquiry.enquiryId}</td>
			<td>${enquiry.customerName}</td>
			<td>${enquiry.jobType}</td>
			<td>${enquiry.loanAmount}</td>
			<td>${enquiry.interestRate}</td>
			<td>${enquiry.loanStatus}</td>
			
			<td><a href="ModifyRecord?eqid=${enquiry.enquiryId}&flag=${'a'}">APPROVE</a></td>

      	</tr>
</c:when>


 <c:otherwise>
<tr class="warning">
        	<td>${enquiry.enquiryId}</td>
			<td>${enquiry.customerName}</td>
			<td>${enquiry.jobType}</td>
			<td>${enquiry.loanAmount}</td>
			<td>${enquiry.interestRate}</td>
			<td>${enquiry.loanStatus}</td>
			<td><a href="ModifyRecord?eqid=${enquiry.enquiryId}&flag=${'r3'} ">RECOMMEND</a></td>
            
            
            
      	</tr>
</c:otherwise>


</c:choose>
    </c:forEach>  
    </tbody>
  </table>
	
	

</div>

 </body>
</html>