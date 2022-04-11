<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/blogs/login.css">
</head>
<body>
	<div class="login-box">
		<h2>Login</h2>
		<form method="post" action="Login">
			<div class="user-box">
				<input type="text" name="userName" required=""> <label>Username</label>
			</div>
			<div class="user-box">
				<input type="password" name="userPassword" required=""> <label>Password</label>
			</div>
			<div class = "btn-submit-div">
				<input type = "submit" value = "LOGIN" class = "btn-submit">
				<a href="./signUp.jsp">Create a new Account</a>
			</div>
		</form>
	</div>
</body>
</html>