<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="controllers.api.movies.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="index.css">
</head>
<body>
	<%
	MovieCard movieCard = (MovieCard) request.getAttribute("movieCard");
	%>

	<form action="SearchMovieData" method="get">
		<input type="text" value= "<%=movieCard.getId()%>" name = "inputMovieID" hidden>
		<div class="card">
			<%=movieCard.getImage()%>
			<input type="submit" class="submit" value ="">
			<%=movieCard.getTitle()%>
		</div>
	</form>
</body>
</html>