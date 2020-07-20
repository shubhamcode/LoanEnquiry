<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enquiry Form</title>
</head>
<body>
<h1 align="center">Enquiry Form</h1>

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






</body>
</html>