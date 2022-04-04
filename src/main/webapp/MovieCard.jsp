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
	
	<c:forEach var="movieCard" items="${resultMovieCards}">
	
        <form action="SearchMovieData" method="get">
        <input type="text" value= "<c:out value="${movieCard.getId()}" />" name = "inputMovieID" hidden>
        <div class="card">
            <c:out value="${movieCard.getImage()}" />
            <input type="submit" class="submit" value ="">
            <c:out value="${movieCard.getTitle()}" />
        </div>
    </form>

    </c:forEach>

	
</body>
</html>