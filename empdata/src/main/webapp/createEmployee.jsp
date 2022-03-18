<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CREATE EMPLOYEE</title>
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
<p><font color="green">${message}</font></p>
<form action="/createemployee" method="post">
FIRST NAME:<br><input type="text" name="firstname"/><br>
LAST NAME:<br><input type="text" name="lastname"/><br>
AGE:<br><input type="text" name="age"/><br>
SALARY:<br><input type="text" name="salary"/><br>
DESIGNATION:<br><input type="text" name="designation"/><br>
<input type="submit" value="submit" />
</form>
</div>
</body>
</html>