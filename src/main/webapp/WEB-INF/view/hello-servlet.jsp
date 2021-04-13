<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello Servlet</title>
</head>
<body>
  <p><%= request.getAttribute("message") != null? request.getAttribute("message") : "This is a default message.."%></p>
</body>
</html>