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
	<h1>Add A New Venue</h1>
	<form action="addVenueServlet" method="post">
		<label for="addVenueName">Venue Name:</label> 
		<input type="text"name="addVenueName" id="addVenueName"><br><br>
		 <label for="addVenueAddress">Venue Address:</label> 
		 <input	type="text" name="addVenueAddress" id="addVenueAddress"><br><br>
		 <div class = "flex-center">
		 		<button type="submit" value="Submit">Submit</button>
		 </div>

		<br>
		<br>
	</form>
	<div class = "flex-center">
		<button onclick="window.location.href='index.html'" class = "button2">Return Home</button>
		<button onclick="window.location.href='manageVenueListServlet'" class = "button2">Edit Venue</button>
		<button onclick="window.location.href='manageVenueListServlet'" class = "button2">Delete Venue</button>
	</div>

	<br>
</body>
</html>