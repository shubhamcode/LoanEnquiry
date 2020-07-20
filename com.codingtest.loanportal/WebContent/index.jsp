<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoanApproval LoginPage</title>
</head>
<body>
<h1 align="center">Welcome to the Loan Approval Login Page </h1>

<form method="POST" action="LoginValidate">
<table border="15" align="center" bgcolor="skyblue">
<tr>
<th colspan="2">Login</th>
</tr>
<tr><td>
UserId
</td><td><input type="text" name="uid" placeholder="USERID"/></td></tr>
<tr><td>
Password
</td><td><input type="password" name="pwd" placeholder="Password"/></td></tr>

<tr><td colspan="2" align="center"><button type="submit">Submit</button><button type="reset">Reset</button></td></tr>

</table>



</form>


</body>
</html>