<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>
<h1>Error</h1>
    <p><%=request.getAttribute("error") %></p>
    <p><a href="first.jsp">Back to Home</a></p>
</body>
</html>