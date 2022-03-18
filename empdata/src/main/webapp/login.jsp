<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN LOGIN</title>
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
<h1>Admin Login</h1>
<p><font color="red">${errormessage}</font></p>
    <form action="/login" method="POST">
        Name:<br><input name="name" type="text" /><br> 
        Password:<br><input name="password" type="password" /><br>
        <input type="submit" />
    </form>
    </div>
</body>
</html>