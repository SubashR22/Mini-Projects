package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.*;
import java.net.*;
import java.util.*;
import com.google.gson.*;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;

public class conservlett extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public conservlett() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String myapikey = "6277966ff5ddc66d2c0ae11859e6e476";//Enter your API Key
        String locationname = request.getParameter("locationname");
        if (locationname == null || locationname.trim().isEmpty()) {
            request.setAttribute("error", "Please enter the name of the place.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }
        String apiurl = "https://api.openweathermap.org/data/2.5/weather?q=" + locationname + "&appid=" + myapikey;

        try {
            URL url = new URL(apiurl);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setRequestMethod("GET");

            InputStream is = huc.getInputStream();
            InputStreamReader hsr = new InputStreamReader(is);
            StringBuilder responseContent = new StringBuilder();
            Scanner s = new Scanner(hsr);

            while (s.hasNext()) {
                responseContent.append(s.nextLine());
            }

            Gson gson = new Gson();
            JsonObject jo = gson.fromJson(responseContent.toString(), JsonObject.class);

            int kelvin = jo.getAsJsonObject("main").get("temp").getAsInt();
            int celcius = (int) (kelvin - 273.15);
            int humidity = jo.getAsJsonObject("main").get("humidity").getAsInt();
            double windSpeed = jo.getAsJsonObject("wind").get("speed").getAsDouble()*3.6;
            int visibilityInMeter = jo.get("visibility").getAsInt();
            int visibility = visibilityInMeter / 1000;
            int pressure = jo.getAsJsonObject("main").get("pressure").getAsInt();
            String weatherCondition = jo.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();
            DecimalFormat df = new DecimalFormat("#.####");
            String formattedWindSpeed = df.format(windSpeed);
            Date d1 = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat(" dd/MM/yyyy hh:mm a");
            String formattedDate = sdf.format(d1);
            
            HttpSession session = request.getSession();
            session.setAttribute("city", locationname);
            session.setAttribute("temperature", celcius);
            session.setAttribute("humidity", humidity);
            session.setAttribute("wind", formattedWindSpeed);
            session.setAttribute("visibility", visibility);
            session.setAttribute("pressure", pressure);
            session.setAttribute("weathercondition", weatherCondition);
            session.setAttribute("dateandTime", formattedDate);
            session.setAttribute("weatherData", responseContent.toString());
           
            response.sendRedirect("second.jsp");
            s.close();
            hsr.close();
            is.close();
        } catch (FileNotFoundException e) {
        	 request.setAttribute("error", "Enter correct place.");
             request.getRequestDispatcher("error.jsp").forward(request, response);
        }catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error fetching weather data. Please try again.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
       
    }

    
}
