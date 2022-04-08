<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="models.api.movies.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/api/movies/movieCard.css">

</head>
<body class = "movieCard-body">

	
	<div class="container spaceTop">
		<div class="row">
			<c:forEach var="movieCard" items="${resultMovieCards}">
				<div class="col-lg-3 col-md-4">
					<form action="SearchMovieData" method="get">
						<input type="text" value="${movieCard.getId()}"
							name="inputMovieID" hidden>

						<div class="movieCard">
							<img src="${movieCard.getImage()}"> <input type="submit"
								class="submit" value="">
						</div>
						<h3>${movieCard.getTitle()}</h3>
					</form>
				</div>

			</c:forEach>
		</div>

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>