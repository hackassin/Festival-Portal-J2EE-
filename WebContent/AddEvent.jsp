<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Dashboard</title>
<link rel = "stylesheet" href = "css/add_event.css">
</head>
<body bgcolor="black">
<a href="AdminHome.jsp" class="button"><b>Home</b></a>

<a href="ViewAllEvents.htm" class="button"><b>View Events</b></a>

<br><br><hr><br>
<h3>${eventAdd}</h3>

<form name = "AddEvent" action = "AddEvent.htm">
<table align = "center">

<tr><th colspan = "7" align="center"> Add Event Details </th></tr>
<tr><th>EventID</th> <th>Name</th> <th>Description</th> <th>Places</th> <th>Duration</th> 
<th>Event Type</th> <th>SeatsAvailable</th></tr>

<tr> 
	 <th><input type = "text" name = "eventid"></th>
	 <th><input type = "text" name = "eventname"></th>
	 <th><input type = "text" name = "description"></th>
	 <th><input type = "text" name = "place"></th>
	 <th><input type = "text" name = "duration"></th>
	 <th><input type = "text" name = "eventtype"></th>
	 <th><input type = "text" name = "seats"></th>
</tr>	 
</table>
<h3 align = "center"><input type = "submit" value = "Add Event" class = "button"></h3>
</form>

</body>
</html>