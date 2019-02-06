<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Festival Portal</title>
<script type="text/javascript" src = "js/UpdateValidation.js"> </script>
<link rel = "stylesheet" href = "css/visitor_profile.css">
</head>
<body background = "Resources\visitor_profile_(1366 x 911).jpeg">

<div style = "clear: left; float: left; text-align: left;">
<a href="ViewAllEvents.htm" class="button"><b>Home</b></a>
</div>

<div style = "clear: right; float: right; text-align: right;">
<a href="Logout.htm" class="button" ><b>Logout</b></a>
</div>

<h3 align = "center"> ${ProfileName}</h3>
<br>
<hr>
<h5 align = "left">${UpdateMessage}</h5>

<br><br><br>

<!-- Visitor Details -->
<form name = "UpdateForm" action = "UpdateVisitor.htm" onsubmit = "return UpdateValidation()" method = "post">

<table id = "visitor" align = "center" style = "color:white">
<!-- Table Heading -->
<tr><th colspan = "4"><h3>Account Information</h3></th></tr>
<!-- Row 1 (VisitorID) -->
<tr>
<th>VisitorID</th><td colspan = "3">${visitor.getVisitorId()}</td>
</tr>

<!-- Row 2 (Username) -->
<tr>
<th>Username</th><td>${visitor.getUsername()}</td> <th colspan = "2" align = "left">New Username  <input type ="text" class = "update" name="username" value= "${visitor.getUsername()}"  required> </th>
</tr>

<!-- Row 3 (Password) -->
<tr>
<th>Password</th><td>${visitor.getPassword()}</td> <th align = "left">New Password  <input type ="password" name="password" value= "${visitor.getPassword()}" required> </th>
<th align = "left">Confirm Password <input type ="password" name="confirm_password" value= "${visitor.getPassword()}" required> </th>
</tr>

<!-- Row 4 (Firstname) -->
<tr>
<th>Firstname</th><td>${visitor.getFirstname()}</td> <th align = "left" colspan = "2">New Firstname  <input type ="text" name="firstname" value= "${visitor.getFirstname()}" required> </th>
</tr>

<!-- Row 5 (Lastname) -->
<tr>
<th>Lastname</th><td>${visitor.getLastname()}</td> <th align = "left" colspan = "2">New Lastname  <input type ="text" name="lastname" value= "${visitor.getLastname()}" required> </th>
</tr>

<!-- Row 6 (Email) -->
<tr>
<th>Email</th><td>${visitor.getEmail()}</td> <th align = "left" colspan = "2">New Email  <input type ="email" name="email" value= "${visitor.getEmail()}" required> </th>
</tr>

<!--  Row 7 (Phonenumber) -->
<tr>
<th>Phone</th><td>${visitor.getPhonenumber()}</td> <th align = "left" colspan = "2">New Phonenumber  <input type ="text" name="phonenumber" value= "${visitor.getPhonenumber()}" required> </th>
</tr>

<!-- Row 8 (Address) -->
<tr>
<th>Address</th><td>${visitor.getAddress()}</td> <th align = "left" colspan = "2">New Address  <input id = "update" type ="text" name="address" value= "${visitor.getAddress()}" required> </th>
</tr>

</table>
<h3 align = "center"><input type = "submit" value = "Update Info" class = "button"></h3>
</form>
</body>
</html>