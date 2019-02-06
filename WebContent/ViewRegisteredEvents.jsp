<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Events</title>
</head>
<body>
<p/>
<p/>


<br>
<br>
<br>
  
<table border = "2" align = "center">

<tr align = "center"><th colspan = "7">RegisteredEvents</th></tr>

<tr align = "center"><td>EventID</td> 
<td>Name</td> <td>Description</td> 
<td>Places</td> <td>Duration</td> 
<td>Event Type </td>  <td> Action</td> </tr>

<core:forEach items="${registeredEvents}" var="event">

<tr align = "center">

<td><core:out value="${event.getEventid()}" /></td> 
<td><core:out value="${event.getName()}"/></td> 
<td><core:out value="${event.getDescription()}"/></td> 
<td><core:out value="${event.getPlace()}"/></td> 
<td><core:out value="${event.getDuration()}"/></td> 
<td><core:out value="${event.getEventtype()}"/></td> 

<!--  <td> <a href = "EventSignup.htm?eventid=${event.getEventid()}">Register</a> </td> -->
</core:forEach>
</table>


</body>
</html>