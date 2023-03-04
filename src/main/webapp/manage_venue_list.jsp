<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Venue's</title>
<!-- include the css file -->
<style><%@include file = "/styles.css"%></style>
</head>
<body>
<h1>All Of The Venues</h1>
<form method = "post" action = "manageVenueServlet">
	<h2>Make A Selection</h2>
	<table>
	<c:forEach items="${requestScope.allVenues }" var = "currentitem" >
	<tr>
		<td><input type = "radio" name = "id" value = "${ currentitem.id }"></td>
		<td>${currentitem.venueName}</td>
		<td>${currentitem.venueAddress}</td>
	</tr>
	</c:forEach>
	</table>
		<div class = "flex-center">
		<button type = "submit" value = "edit" name = "doThisToItem">Edit</button>
		<button type = "submit" value = "delete" name = "doThisToItem">Delete</button>
		<button type = "submit" value = "add" name = "doThisToItem">Add</button>
	</div>
</form>
<div class = "flex-center">
	<button onclick="window.location.href='index.html'" class = "button2">Return Home</button>
</div>

</body>
</html>