# Weather Forecast Application

This is a Java-based web application that provides weather forecasts for a given location using the OpenWeatherMap API. The application is built using Java, JSP, Servlet, HTML, CSS, and JavaScript, and uses the Gson library for JSON parsing. The project is managed using the Maven build tool.

## Features

- Enter a location to get the current weather information.
- Display temperature, humidity, weather condition, pressure, and other weather-related data.
- User-friendly interface with responsive design.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 8 or higher
- Apache Tomcat server
- Maven
- Internet connection to access the OpenWeatherMap API

## Getting Started

1. Clone the Repository
```bash
git clone https://github.com/yourusername/weather-forecast.git
cd weather-forecast
```
2. Obtain OpenWeatherMap API Key
Go to OpenWeatherMap and sign up for an API key.
Note down your API key.
3. Configure the Application
Open the src/main/resources/config.properties file.
Add your OpenWeatherMap API key:
```bash
properties
Copy code
api.key=YOUR_API_KEY_HERE
```
5. Build the Project
Use Maven to build the project:
```bash
Copy code
mvn clean install
```
6. Deploy to Tomcat<br>
1.Copy the generated WAR file from the target directory to the webapps directory of your Tomcat server.<br>
2.Start the Tomcat server.
7. Access the Application<br>
Open your web browser and go to http://localhost:8080/weather-forecast.
## Project Structure
```bash
weather-forecast/
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── weather
│   │   │               ├── controller
│   │   │               │   └── WeatherServlet.java
│   │   │               ├── model
│   │   │               │   └── Weather.java
│   │   │               └── service
│   │   │                   └── WeatherService.java
│   │   ├── resources
│   │   │   └── config.properties
│   │   └── webapp
│   │       ├── WEB-INF
│   │       │   └── web.xml
│   │       ├── css
│   │       │   └── styles.css
│   │       ├── js
│   │       │   └── script.js
│   │       └── index.jsp
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── weather
│                       └── WeatherServletTest.java
└── pom.xml
```
## Dependencies
The project uses the following dependencies:

- Gson: For JSON parsing.
- Servlet API: For building the web application.
- JSP: For rendering the views.
- OpenWeatherMap API: For fetching weather data.
### Add these dependencies in your pom.xml file:
```bash
<dependencies>
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>4.0.1</version>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.8.8</version>
    </dependency>
</dependencies>
```
## Usage
1.Enter the location in the input field on the home page.<br>
2.Click the "Get Weather" button.<br>
3.The application will display the current weather details for the specified location.<br>
