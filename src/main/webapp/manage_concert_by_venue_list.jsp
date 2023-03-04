<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Concerts by Venue</title>
</head>
<body>
<style><%@include file = "/styles.css"%></style>
</head>
<body>
<form method = "post" action = "manageConcertByVenueServlet">
	<table>
	<c:forEach items="${requestScope.concertsByVenue }" var = "currentitem" >
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
</form>
	<button onclick="window.location.href='index.html'">Return Home</button>
</body>
</html>