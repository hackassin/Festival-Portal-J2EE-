<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Dashboard</title>
<link rel = "stylesheet" href = "css/admin_home.css">
</head>
<body bgcolor = "black">
<a href="AdminHome.jsp" class="button"><b>Home</b></a>

<br><br><hr><br>

<!-- Event Details -->

<form name = "UpdateForm" action = "UpdateEvents.htm" method = "post">

<table align = "center" style = "color:white">
<!-- Table Heading -->
<tr><th colspan = "3"><h3>Update Event Details</h3></th></tr>
<!-- Row 1 (EventID) -->
<tr>
<th>EventID</th><td>${event.getEventid()}</td>
</tr>

<!-- Row 2 (Event Name) -->
<tr>
<th>Name</th><th align = "left"><input type ="text" name="eventname" value= "${event.getName()}"  required> </th>
</tr>

<!-- Row 3 (Event Description) -->
<tr>
<th>Description</th><th align = "left"><input type ="text" name="description" value= "${event.getDescription()}" required> </th>


<!-- Row 4 (Event Place) -->
<tr>
<th>Place</th><th align = "left"><input type ="text" name="place" value= "${event.getPlace()}" required> </th>
</tr>

<!-- Row 5 (Duration) -->
<tr>
<th>Duration</th><th align = "left"><input type ="text" name="duration" value= "${event.getDuration()}" required> </th>
</tr>

<!-- Row 6 (Event type) -->
<tr>
<th>Event Type</th><th align = "left"><input type ="text" name="eventtype" value= "${event.getEventtype()}" required> </th>
</tr>

<!--  Row 7 (Seats Available) -->
<tr>
<th>Seats Available</th><th align = "left"><input type ="text" name="seats" value= "${event.getSeatsavailable()}" required> </th>
</tr>

</table>
<h3 align = "center"><input type = "submit" value = "Update Info" class = "button"></h3>
</form>
</body>
</html>