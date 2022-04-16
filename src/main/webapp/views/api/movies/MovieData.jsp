<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<link rel="stylesheet" type="text/css"
	href="css/api/movies/movieData.css">
</head>
<body class="movieData-body">
<jsp:include page="/header.jsp" /> 
<br>
<br>
	<div class="container">
		<div class="row justify-content-md-center">
			<div class="col-lg-3 col-md-12">
				<img src="${movieData.getImage()}" class="movieData-img">
			</div>
			<div class="col-lg-9 col-md-12">
				<h4>${movieData.getFullTitle()}</h4>
				<pre>
IMDB Ratings    :   ${movieData.getImDbRating() }/10.0
Budget          :   ${movieData.getBoxOffice().getBudget() }
Box Office      :   ${movieData.getBoxOffice().getCumulativeWorldwideGross() }
Genre           :   <c:forEach var="genre"
						items="${movieData.getGenres() }">${genre} </c:forEach>
			</pre>
				<p class="plot" >${movieData.getPlot() }</p>
			</div>
		</div>
		<br>
		<h5>Characters :</h5>
		<div class="row justify-content-md-center">
			<c:forEach var="actor" items="${movieData.getActorList() }">

				<div class="col-lg-2 col-md-4">
					<div class="character">
						<img src="${actor.getImage()}">
						<p class="name">${actor.getName()}</p>
						<p class="character-name">${actor.getAsCharacter()}</p>
					</div>
				</div>

			</c:forEach>
		</div>
		<br>
		<h5>Similar Movies :</h5>
		<c:set var="resultMovieCards" scope="session"
			value="${movieData.getSimilars()}" />
		<jsp:include page="MovieCardData.jsp" />
	</div>
<jsp:include page="/footer.html" /> 
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>