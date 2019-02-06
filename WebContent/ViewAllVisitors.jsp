<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Dashboard</title>
<link rel = "stylesheet" href = "css/admin_home.css">
</head>
<body bgcolor = "black">
<div style = "clear: left; float: left; text-align: left;">
<a href="AdminHome.jsp" class="button"><b>Home</b></a>
</div>

<div style = "clear: right; float: right; text-align: right;">
<a href="Logout.htm" class="button" ><b>Logout</b></a>
</div> <br> <br> <br> <br>
<hr>
<br><br><br>
<table align = "center" style = "color:white">

<tr align = "center"><th colspan = "7">Visitors List</th></tr>

<tr align = "center"><td>VisitorID</td> 
<td>Username</td> <td>Firstname</td> 
<td>Lastname</td> <td>Address</td> 
<td>Email</td> <td>Phonenumber</td> 

<core:forEach items="${visitor}" var="visitor">

<tr align = "center">

<td><core:out value="${visitor.getVisitorId()}" /></td> 
<td><core:out value="${visitor.getUsername()}"/></td> 
<td><core:out value="${visitor.getFirstname()}"/></td> 
<td><core:out value="${visitor.getLastname()}"/></td> 
<td><core:out value="${visitor.getAddress()}"/></td> 
<td><core:out value="${visitor.getEmail()}"/></td> 
<td><core:out value="${visitor.getPhonenumber()}"/></td>

</tr> </core:forEach></table>
</body>
</html>