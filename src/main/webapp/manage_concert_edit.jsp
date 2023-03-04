<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- include the css file -->
<style><%@include file = "/styles.css"%></style>
<title>Manage Concert</title>
</head>
<body>
	<h1>Edit Concert Details</h1>
	<form action = "manageConcertEditServlet" method = "post">
		<label for="editVenueName">Venue Name:</label> 
		<input type="text"name="editVenueName" id="editVenueName" value = "${editItem.locationName.venueName }"><br><br>
		<label for="editVenueAddress">Venue Address:</label> 
		<input	type="text" name="editVenueAddress" id="editVenueAddress" value = "${editItem.locationName.venueAddress }"><br><br>
		 <label for="editBandName">Band Name:</label> 
		<input	type="text" name="editBandName" id="editBandName" value = "${editItem.bandName }"><br><br>
		 <label for="editBandDescription">Band Description:</label> 
		<input	type="text" name="editBandDescription" id="editBandDescription" value = "${editItem.bandDescription }"><br><br>
		<label for="editBandName">Venue Address:</label> 
		<input	type="date" name="editConcertDate" id="editConcertDate" value = "${editItem.concertDate }"><br><br>
		<input type = "hidden" name = "id" value = "${editItem.id }">
		 <div class= "flex-center">
		 		<button type="submit" value="Submit">Commit Edit</button>
		 </div>

		<br>
		<br>
	</form>
</body>
</html>