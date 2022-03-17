<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CREATE EMPLOYEE</title>
<style type="text/css">
.div{
border: 5px outset red;
background-color: lightblue;
text-align: center;
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