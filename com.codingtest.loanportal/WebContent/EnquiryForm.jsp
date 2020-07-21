<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
 

<title>Enquiry Form</title>

<% 
  	HttpSession sess=request.getSession();
	if(sess.getAttribute("userName")==null)
		response.sendRedirect("index.jsp");
%>
</head>
<body>


<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12"><h1 align="center">ENQUIRY FORM</h1></div>
	</div>
	<form class="form-horizontal" action="EnquiryController" method="GET">
		<div class="form-group form-row">
      			<div class="col-sm-4"></div>
				
      			<div class="col-sm-4">          
        			<input type="text" class="form-control" name="eqid" placeholder="Enquiry No." required>
      			</div>
      			
      			<div class="col-sm-4"></div>
    		</div>
		
		<div class="form-group form-row">
      			
				<div class="col-sm-4"></div>
      			<div class="col-sm-4">          
        			<input type="text" class="form-control" name="cname" placeholder="Customer Name" required>
      			</div>
      			<div class="col-sm-4"></div>
    		</div>
    	
    	<div class="form-group form-row">
      			<div class="col-sm-4"></div>
				
      			<div class="col-sm-4">          
        			<input type="text" class="form-control"  name="jobtype" placeholder="Job Type" required>
      			</div>
      			
      			<div class="col-sm-4"></div>
    		</div>
		<div class="form-group form-row">
      			<div class="col-sm-4"></div>
				
      			<div class="col-sm-4">          
        			<input type="number" class="form-control" name="lamount" placeholder="Loan Amount" required>
      			</div>
      			
      			<div class="col-sm-4"></div>
    		</div>
		<div class="form-group form-row">
      			<div class="col-sm-4"></div>
				
      			<div class="col-sm-4">          
        			<input type="number" class="form-control" name="irate" placeholder="Interest Rate" required>
      			</div>
      			
      			<div class="col-sm-4"></div>
    		</div>
			


			<div class="form-group form-row">
    			<div class="col-sm-5"></div>
				<div class="col-sm-1">
      				<button type="submit" class="btn btn-group-lg btn-primary">Submit</button>
    			</div>
				<div class="col-sm-1">
      				<button type="submit" class="btn btn-group-lg btn-primary">Reset</button>
    			</div>

  			</div>
		
	</form>
</div>




<!-- <h1 align="center">Enquiry Form</h1>

<form action="EnquiryController" method="GET">
<table border="15" align="center" bgcolor="skyblue">
<tr>
<th colspan="2">Please fill in the below fields</th>
</tr>
<tr><td>
Enquiry Id
</td><td><input type="text" name="eqid" placeholder="Enquiry No."/></td></tr>
<tr><td>
Customer Name
</td><td><input type="text" name="cname" placeholder="Customer Name"/></td></tr>
<tr><td>
Job Type
</td><td><input type="text" name="jobtype" placeholder="Enquiry No."/></td></tr>
<tr><td>
Loan Amount
</td><td><input type="text" name="lamount" placeholder="Total Amount"/></td></tr>
<tr><td>
Interest Rate
</td><td><input type="number" name="irate" placeholder="Interest in %"/></td></tr>


<tr><td colspan="2" align="center"><button type="submit">Submit</button><button type="reset">Reset</button></td></tr>

</table>



</form>




 -->

</body>
</html>