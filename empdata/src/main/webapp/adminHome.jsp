<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN HOME</title>
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
<form action="/create">
Create Employee:<br><input type="submit" value="CREATE"/>
</form>
<form action="/search" method="get">
Search Employee:<br><input type="submit" value="SEARCH"/>
</form>
<form action="/update">
Update Employee:<br><input type="submit" value="UPDATE"/>
</form>
<form action="/delete">
Delete Employee:<br><input type="submit" value="DELETE"/>
</form>
</div>
</body>
</html>