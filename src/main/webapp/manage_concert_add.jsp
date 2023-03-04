<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Concerts's</title>
<!-- include the css file -->
<style><%@include file = "/styles.css"%></style>
</head>
<body>
<h1>Add A New Concert</h1>
	<form action = "addConcertServlet" method = "post">
		<label for="addLocationName">Venue Name</label>
		<input type = "text" name = "addLocationName" id = "addLocationName"><br><br>
		<label for="addBandName">Band Name</label>
		<input type = "text" name = "addBandName" id = "addBandName"><br><br>
		<label for="addBandDescription">Band Description</label>
		<input type = "text" name = "addBandDescription" id = "addBandDescription"><br><br>
		<label for="addConcertDate">Concert Date:</label>
		<input type = "date" name = "addConcertDate" id = "addConcertDate"><br><br>
		<div class ="flex-center">
			<button type="submit" value="Submit">Submit</button>
		</div>

		<br><br>
	</form>
	<div class = "flex-center">
		<button onclick="window.location.href='index.html'" class = "button2">Return Home</button>
		<button onclick="window.location.href='manageConcertListServlet'" class = "button2">Edit Concert</button>
		<button onclick="window.location.href='manageConcertListServlet'" class = "button2">Delete Concert</button>
	</div>
	
</body>
</html>