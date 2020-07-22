<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
   

<title>LoanApproval LoginPage</title>
</head>
<body>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12"><h1 align="center">Welcome to the Loan Approval Login Page </h1></div>
	</div>
	<div class="row">
		<div class="col-sm-12"><h1 align="center">Login Here</h1></div>
	</div>
	<form class="form-horizontal" action="LoginValidate" method="POST" id="formlogin"">
		<div class="form-group form-row">
      			<div class="col-sm-4"></div>
				
      			<div class="col-sm-4">          
        			<input type="text" class="form-control" name="uid" placeholder="UserID" id="username">
      			</div>
      			
      			<div class="col-sm-4"><span id="errorUname" class="text-danger"></span></div>
    		</div>
		
		<div class="form-group form-row">
      			
				<div class="col-sm-4"></div>
      			<div class="col-sm-4">          
        			<input type="password" class="form-control" name="pwd" placeholder="Password" id="password">
      			
      			</div>
      			
      			<div class="col-sm-4"><span id="errorPass" class="text-danger"></span></div>
    		</div>

			<div class="form-group form-row">
    			<div class="col-sm-5"></div>
				<div class="col-sm-1">
      				<button type="submit" class="btn btn-group-lg btn-primary">Submit</button>
    			</div>
				<div class="col-sm-1">
      				<button type="reset" class="btn btn-group-lg btn-primary">Reset</button>
    			</div>

  			</div>
		
	</form>
	
<div class="row">
		<div class="col-sm-12"><h1 align="center"><span class="text-danger font-weight">${statusmgs}</span></h1></div>
	</div>
		
</div>


<script>

$(function(){
	
	$("#errorUname").hide();
	$("#errorPass").hide();
	
	var err_uname=false;
	var err_pass=false;
	
	$("#username").focusout(function(){ chk_uname();});
	$("#password").focusout(function(){ chk_pass();});
	
	
	function chk_uname(){
		var uname=$("#username").val();
		if( uname.length>3)
		  {
			$("#errorUname").hide();
			$("#username").css("border-color", "green");
		  }
		else
			{
			$("#errorUname").html("UserId is not valid");
			$("#errorUname").show();
			$("#username").css("border-color", "red");
			err_uname=true;
			}
		
		
	}
	
	function chk_pass(){
		var pwd=$("#password").val();
		if(pwd.length!=0)
		  {
			$("#errorPass").hide();
			$("#password").css("border-color", "green");
		  }
		else
			{
			$("#errorPass").html("Cannot be blank.");
			$("#errorPass").show();
			$("#password").css("border-color", "red");
			err_pass=true;
			}
		
		
	}
	

	
	$("#formlogin").submit(function(){
		err_uname=false;
		err_pass=false;
		
		chk_uname();
		chk_pass();
		
		if(err_pass == false && err_uname == false)
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