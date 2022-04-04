<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="controllers.api.movies.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="index.css">
</head>
<body>
	<%
	ArrayList<MovieCard> resultMovieCards = (ArrayList<MovieCard>) request.getAttribute("resultMovieCards");
	%>
	
	
	<c:set var = "i" value = "23" scope = "application"></c:set>
	<h1><c:out value = "${i}"></c:out></h1>
	
</body>
</html>