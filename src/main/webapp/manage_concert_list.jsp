<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Concert's</title>
<!-- include the css file -->
<style><%@include file = "/styles.css"%></style>
</head>
<body>
<form method = "post" action = "manageConcertServlet">
	<table>
	<c:forEach items="${requestScope.allConcerts }" var = "currentitem" >
	<tr>
		<td><input type = "radio" name = "id" value = "${ currentitem.id }"></td>
		<td>${currentitem.locationName.venueName}</td>
		<td>${currentitem.locationName.venueAddress}</td>
		<td>${currentitem.bandName}</td>
		<td>${currentitem.bandDescription}</td>
		<td>${currentitem.concertDate}</td>
	</tr>
	</c:forEach>
	</table>
	<button type = "submit" value = "edit" name = "doThisToItem">Edit</button>
	<button type = "submit" value = "delete" name = "doThisToItem">Delete</button>
	<button type = "submit" value = "add" name = "doThisToItem">Add</button>
</form>
	<button onclick="window.location.href='index.html'">Return Home</button>
</body>
</html>