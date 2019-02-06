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
<a href="AdminHome.jsp" class="button"><b>Home</b></a> <br>
<hr>
<h3 align = "center">${Delete_Msg}</h3>
<h3 align = "center">${UpdateMessage}</h3>
<br><br><br>
<table id = "Events" align = "center" style = "color:white">

<tr align = "center"><th colspan = "9">All Events</th></tr>

<tr align = "center"><td>EventID</td> 
<td>Name</td> <td>Description</td> 
<td>Places</td> <td>Duration</td> 
<td>Event Type </td> <td> Seats Available</td> <td colspan = "2"> Action</td> </tr>

<core:forEach items="${allEvents}" var="event">

<tr align = "center">

<td><core:out value="${event.getEventid()}" /></td> 
<td><core:out value="${event.getName()}"/></td> 
<td><core:out value="${event.getDescription()}"/></td> 
<td><core:out value="${event.getPlace()}"/></td> 
<td><core:out value="${event.getDuration()}"/></td> 
<td><core:out value="${event.getEventtype()}"/></td> 
<td><core:out value="${event.getSeatsavailable()}"/></td> 
<td> <a href = "DeleteEvents.htm?eventid=${event.getEventid()}">Delete</a> </td>
<td> <a href = "UpdateEventProfile.htm?eventid=${event.getEventid()}">Update</a> </td>
</core:forEach>
</table>

</body>
</html>