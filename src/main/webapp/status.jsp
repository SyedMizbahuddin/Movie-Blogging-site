<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body style ="text-align:center">
	<!-- signUpSuccess userAlreadyExists  signUpFailed loginFailed-->
	<%
	
	String status = (String) request.getAttribute("status");
	if(status == null){
		status = "status";
	}
	if (status.equals("signUpSuccess")) {
	%>
	
	<div class="alert alert-success" role="alert">Sign Up successful!
	</div>
	<a href = "login.jsp">
		<button type="button" class="btn btn-success">Login</button>
	</a>
	
	
	<%
	} else if (status.equals("userAlreadyExists")) {
	%>
	
	<div class="alert alert-danger" role="alert">User already exists!
		Try other user name</div>
		<a href = "signUp.jsp">
		<button type="button" class="btn btn-danger">Sign Up</button>
	</a>
	
	<%
	} else if (status.equals("signUpFailed")) {
	%>
	
	<div class="alert alert-danger" role="alert">Sign Up Failed!
		Please try again</div>
		<a href = "signUp.jsp">
		<button type="button" class="btn btn-danger">Sign Up</button>
	</a>
	
	<%
	} else if (status.equals("loginFailed")) {
	%>
	
	<div class="alert alert-danger" role="alert">Login Failed! Please
		try again</div>
		<a href = "login.jsp">
		<button type="button" class="btn btn-danger">Login</button>
	</a>
	
	<%
	}
	%>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>


