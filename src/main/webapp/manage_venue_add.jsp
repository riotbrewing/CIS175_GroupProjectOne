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
	<h1>ADD A NEW VENUE</h1>
	<form action="addVenueServlet" method="post">
		<label for="addVenueName">Venue Name:</label> 
		<input type="text"name="addVenueName" id="addVenueName"><br><br>
		 <label for="addVenueAddress">Venue Address:</label> 
		 <input	type="text" name="addVenueAddress" id="addVenueAddress"><br><br>
		<button type="submit" value="Submit">Submit</button>
		<br>
		<br>
	</form>
	<button onclick="window.location.href='index.html'">Return Home</button>
	<button onclick="window.location.href='manageVenueListServlet'">Edit Venue</button>
	<button onclick="window.location.href='manageVenueListServlet'">Delete Venue</button>
	<br>
</body>
</html>