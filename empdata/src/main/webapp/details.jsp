<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMPLOYEE DETAILS</title>
<style type="text/css">
.div{
margin: 30px auto;
    padding: 10px;
    width: 400px;
    
	display: flex;
	flex-direction: column;
	align-items: center;
	text-align:center;
	
	border-radius: 10px;
	box-shadow: 2px 2px 2px #888;
	
	background: #0804;
}
</style>
</head>
<body>
<div class="div">
<h3>ID:</h3><br>
<p>${id}</p><br>
<h3>NAME:</h3><br>
<p>${firstname} ${lastname}</p><br>
<h3>AGE:</h3><br>
<p>${age}</p><br>
<h3>SALARY:</h3><br>
<p>${salary}</p><br>
<h3>DESIGNATION:</h3><br>
<p>${designation}</p><br>
<a href="/home">Return Home</a>
</div>
</body>
</html>