<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<link rel="stylesheet" type="text/css" href="css/blogs/login.css">
</head>
<body>
	<div class="login-box">
		<h2>Sign Up</h2>
		<form method="post" action="SignUp">
			<div class="user-box">
				<input type="text" name="FirstName" required=""> <label>Full Name</label>
			</div>
			<div class="user-box">
				<input type="text" name="userName" required=""> <label>Username</label>
			</div>
			<div class="user-box">
				<input type="password" name="userPassword" required=""> <label>Password</label>
			</div>
			<div class = "btn-submit-div">
				<input type = "submit" value = "SIGNUP" class = "btn-submit">
			</div>
		</form>
	</div>
</body>
</html>