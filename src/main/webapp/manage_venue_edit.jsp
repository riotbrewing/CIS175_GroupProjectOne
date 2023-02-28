<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- include the css file -->
<style><%@include file = "/styles.css"%></style>

<title>Manage Venue</title>
</head>
<body>
	<form action = "manageVenueEditServlet" method = "post">
		<label for="addVenueName">Venue Name:</label> 
		<input type="text"name="addVenueName" id="addVenueName" value = "${editItem.venueName }"><br><br>
		 <label for="addVenueAddress">Venue Address:</label> 
		 <input	type="text" name="addVenueAddress" id="addVenueAddress" value = "${editItem.venueAddress }"><br><br>
		 <input type = "hidden" name = "id" value = "${editItem.id }">
		<button type="submit" value="Submit">Commit Edit</button>
		<br>
		<br>
	</form>
</body>
</html>