<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMPLOYEE DETAILS</title>
</head>
<body>
<table>
<tr>
<th>ID</th>
<th>NAME</th>
<th>AGE</th>
<th>SALARY</th>
<th>DESIGNATION</th>
</tr>
<tr>
<td>${id}</td>
<td>${firstname} ${lastname}</td>
<td>${age}</td>
<td>${salary}</td>
<td>${designation}</td>
</tr>
</table>
<a href="/home">Return Home</a>
</body>
</html>