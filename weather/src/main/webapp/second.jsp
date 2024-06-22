<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Weather Details</title>
<link rel="stylesheet" href="jspstyle.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body>
<div class="data">
<h1>Weather Details</h1>
<div class="weatherimage">
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQqhImnN1KCxe8k8DDt0pCl01uqmq6yZDPm3w&s" alt=Weatherimage>
<div class="temp-city">
<h2><i class="fas fa-city"></i> <%= session.getAttribute("city") %></h2>
        <h2><i class="fas fa-thermometer-half"></i> <%= session.getAttribute("temperature") %>&deg;C</h2>
        </div>
        </div>
        <div class="weatherinfo">
        <h2>Humidity: <%= session.getAttribute("humidity") %>%</h2>
        <h2>Wind Speed: <%= session.getAttribute("wind") %> km/h</h2>
        <h2>Visibility: <%= session.getAttribute("visibility") %> km</h2>
        <h2>Pressure: <%= session.getAttribute("pressure") %> hPa</h2>
        <h2>Weather Condition: <%= session.getAttribute("weathercondition") %></h2>
        <h2>Date and Time: <%= session.getAttribute("dateandTime") %></h2>
        </div>
        <p><b>Find any Other Location</b></p>
          <div class="first">
          Enter  Location<br>
        <form action="conservlett" method="post">
        <input type="text" name="locationname">
        <input type="submit" value="Get Weather">
        
        </form>
        </div>
</div>

</body>
</html>