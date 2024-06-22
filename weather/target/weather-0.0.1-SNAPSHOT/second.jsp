<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Weather Details</title>
<link rel="stylesheet" href="jspstyle.css">

</head>
<body>
<div class="data">
<h1>Weather Details</h1>
<div class="weatherimage">
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQqhImnN1KCxe8k8DDt0pCl01uqmq6yZDPm3w&s" alt=Weatherimage>
<h2>City: ${city}</h2>
        <h2>Temperature: ${temperature}&deg;C</h2>
        <h2>Humidity: ${humidity}%</h2>
        <h2>Wind Speed: ${wind} m/s</h2>
        <h2>Visibility: ${visibility} km</h2>
        <h2>Pressure: ${pressure} hPa</h2>
        <h2>Weather Condition: ${weathercondition}</h2>
        <h2>Date and Time: ${dateandTime}</h2>
</div>
</div>
</body>
</html>