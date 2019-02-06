<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Events</title>
<link rel="stylesheet" href = "css/visitor_home.css">
<link rel="stylesheet" href = "css/parallax_bg.css">
</head>


<body>

<div class = "parallax"></div>

<div style = "clear: left; float: left; text-align: left;">
<a href="ViewProfile.htm" class="button"><b>Your Profile</b></a>
</div>

<div style = "clear: right; float: right; text-align: right;">
<a href="Logout.htm" class="button" ><b>Logout</b></a>
</div>
<h3 align = "center">${howdy_msg}</h3>

<br>
<hr>
<br>
<br>
<h2 align = "center">${Reg_Event_Failure}</h2>  <h2 align = center>${Reg_Event_Success}</h2>  
<h2 align = "center">${UnregisterMessage}</h2>  <h2 align = center>${Reg_Event_Error}</h2>
<table id = "Events" align = "center" style = "color:white">

<tr align = "center"><th colspan = "8">All Events</th></tr>

<tr align = "center"><td>EventID</td> 
<td>Name</td> <td>Description</td> 
<td>Places</td> <td>Duration</td> 
<td>Event Type </td> <td> Seats Available</td> <td> Action</td> </tr>

<core:forEach items="${allEvents}" var="event">

<tr align = "center">

<td><core:out value="${event.getEventid()}" /></td> 
<td><core:out value="${event.getName()}"/></td> 
<td><core:out value="${event.getDescription()}"/></td> 
<td><core:out value="${event.getPlace()}"/></td> 
<td><core:out value="${event.getDuration()}"/></td> 
<td><core:out value="${event.getEventtype()}"/></td> 
<td><core:out value="${event.getSeatsavailable()}"/></td> 
<td> <a href = "EventSignup.htm?eventid=${event.getEventid()}">Register</a> </td>
</core:forEach>
</table>

<br>
<br>
<br>
  
<table id = "Events"  align = "center" style = "color:white" style = "background: rgba(90, 100, 100, 0.5)">

<tr align = "center"><th colspan = "7">Registered Events</th></tr>

<tr align = "center"><td>EventID</td> 
<td>Name</td> <td>Description</td> 
<td>Places</td> <td>Duration</td> 
<td>Event Type </td>  <td> Action</td> </tr>

<core:forEach items="${registeredEvents}" var="regEvent">

<tr align = "center">

<td><core:out value="${regEvent.getEventid()}" /></td> 
<td><core:out value="${regEvent.getName()}"/></td> 
<td><core:out value="${regEvent.getDescription()}"/></td> 
<td><core:out value="${regEvent.getPlace()}"/></td> 
<td><core:out value="${regEvent.getDuration()}"/></td> 
<td><core:out value="${regEvent.getEventtype()}"/></td> 
<td> <a href = "Unregister.htm?eventid=${regEvent.getEventid()}">Unregister</a> </td>
<!--  <td> <a href = "EventSignup.htm?eventid=${event.getEventid()}">Register</a> </td> -->
</core:forEach>
</table>


</body>
</html>