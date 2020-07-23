<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
  
 <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
 

<title>Enquiry Form</title>

<% 

response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires","0");

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
	<div class="row">
		<div class="col-sm-11"></div>
		<form action="LogoutPage">
		<div class="col-sm-1"><button type="submit" class="btn btn-group-lg btn-primary">Logout</button></div>
		</form>
	</div>
	<form class="form-horizontal" action="EnquiryController" method="GET" id="formenqiry">
		<div class="form-group form-row">
      			<div class="col-sm-4"></div>
				
      			<div class="col-sm-4">          
        			<input type="text" class="form-control" name="eqid" placeholder="Enquiry No." id="eqid">
      			</div>
      			
      			<div class="col-sm-4"><span class="text-danger" id="errorEnquiry"></span></div>
    		</div>
		
		<div class="form-group form-row">
      			
				<div class="col-sm-4"></div>
      			<div class="col-sm-4">          
        			<input type="text" class="form-control" name="cname" placeholder="Customer Name" id="cname">
      			</div>
      			<div class="col-sm-4"><span class="text-danger" id="errorCname"></span></div>
    		</div>
    	
    	<div class="form-group form-row">
      			<div class="col-sm-4"></div>
				
      			<div class="col-sm-4">          
        			<select class="form-control" name="jobtype" placeholder="Job Type" id="jobtype" required>
        			<option value="" selected disabled>Job Type</option>
        			<option value="Saleried">Salaried</option>
        			<option value="Selfemp">Self Employed</option>
        			</select>
      			</div>
      			
      			<div class="col-sm-4"><span class="text-danger" id="errorJobtype"></span></div>
    		</div>
		<div class="form-group form-row">
      			<div class="col-sm-4"></div>
				
      			<div class="col-sm-4">          
        			<input type="number" class="form-control" name="lamount" placeholder="Loan Amount" step="0.01" id="lamt">
      			</div>
      			
      			<div class="col-sm-4"><span class="text-danger" id="errorLamt"></span></div>
    		</div>
		<div class="form-group form-row">
      			<div class="col-sm-4"></div>
				
      			<div class="col-sm-4">          
        			<input type="number" class="form-control" name="irate" placeholder="Interest Rate" step="0.01" min="0" max="100" id="irate">
      			</div>
      			
      			<div class="col-sm-4"><span class="text-danger" id="errorIrate"></span></div>
    		</div>
			


			<div class="form-group form-row">
    			<div class="col-sm-5"></div>
				<div class="col-sm-1">
      				<button type="submit" class="btn btn-group-lg btn-primary" id="smt">Submit</button>
    			</div>
				<div class="col-sm-1">
      				<button type="reset" class="btn btn-group-lg btn-primary" id="rst">Reset</button>
    			</div>
				<div class="col-sm-5"></div>
  			</div>
		
	</form>
<div class="row">
	<div class="col-sm-4"></div>
	<div class="col-sm-4">
		
		<c:choose>
			
				<c:when test="${enquirystatus=='1'}"><center><span class="text-success font-weight-bold">Enquiry got AUTOAPPROVED.</span></center></c:when>
				<c:when test="${enquirystatus=='2'}"><center><span class="text-success font-weight-bold">Enquiry Submitted for Processing.</span></center></c:when>		
				<c:when test="${enquirystatus=='3'}"><center><span class="text-danger font-weight-bold">Enquiry No.Should Be Unique.</span></center></c:when>		

				<c:otherwise></c:otherwise>		
				
		
		</c:choose>
	
	
	</div>
	<div class="col-sm-4"></div>
	
</div>
	
	
</div>


<script>

$(function(){
	
	$("#errorEnquiry").hide();
	$("#errorCname").hide();
	$("#errorLamt").hide();
	$("#errorIrate").hide();
	$("#errorJobtype").hide();
	
	var err_enq=false;
	var err_cname=false;
	var err_lamt=false;
	var err_irate=false;
	var err_jobtype=false;
	
	$("#eqid").focusout(function(){ chk_enquiry();});
	$("#cname").focusout(function(){ chk_cname();});
	$("#lamt").focusout(function(){ chk_lamt();});
	$("#irate").focusout(function(){ chk_irate();});
	$("#jobtype").focusout(function(){ chk_jobtype();});
	
	
	function chk_enquiry(){
		var eqid=$("#eqid").val();
		if($.isNumeric(eqid) && eqid.length>=3 )
		  {
			$("#errorEnquiry").hide();
			$("#eqid").css("border-color", "green");
		  }
		else
			{
			$("#errorEnquiry").html("Invalid Enquiry id");
			$("#errorEnquiry").show();
			$("#eqid").css("border-color", "red");
			err_enq=true;
			}
		
		
	}
	
	function chk_cname(){
		var cname=$("#cname").val();
		if(cname.length>=3 )
		  {
			$("#errorCname").hide();
			$("#cname").css("border-color", "green");
		  }
		else
			{
			$("#errorCname").html("Name is Invalid");
			$("#errorCname").show();
			$("#cname").css("border-color", "red");
			err_cname=true;
			}
		
		
	}
	
	function chk_lamt(){
		var lamt=$("#lamt").val();
		if(lamt==0 )
		  {

			$("#errorLamt").html("Loan Amt cannot be 0.");
			$("#errorLamt").show();
			$("#lamt").css("border-color", "red");
			err_lamt=true;
			
		  }
		else
			{
			

			$("#errorLamt").hide();
			$("#lamt").css("border-color", "green");
			
			}
		
		
	}
	
	function chk_irate(){
		var irate=$("#irate").val();
		if(irate==0 )
		  {

			$("#errorIrate").html("Rate cannot be 0");
			$("#errorIrate").show();
			$("#irate").css("border-color", "red");
			err_irate=true;
			
		  }
		else
			{
			

			$("#errorIrate").hide();
			$("#irate").css("border-color", "green");
			
			}
		
		
	}
	
	function chk_jobtype(){
		var jobtype=$("#jobtype").val();
		if(jobtype.length==0)
		  {

			$("#errorJobtype").html("Please Select any one.");
			$("#errorJobtype").show();
			$("#jobtype").css("border-color", "red");
			err_jobtype=true;
			
		  }
		else
			{
			

			$("#errorJobtype").hide();
			$("#jobtype").css("border-color", "green");
			
			}
		
		
	}
	
	
	$("#formenqiry").submit(function(){
		err_enq=false;
		err_cname=false;
		err_lamt=false;
		err_irate=false;
		err_jobtype=false;
		
		chk_enquiry();
		chk_cname();
		chk_lamt();
		chk_irate();
		chk_jobtype();
		
		if(err_enq == false && err_cname == false && err_lamt==false && err_irate==false && err_jobtype==false)
			{
			  
			  return true;
			}
		else
			{	
			alert("Some data is not correct.");
			return false;
			}
			
		
	});
});


</script>







</body>
</html>