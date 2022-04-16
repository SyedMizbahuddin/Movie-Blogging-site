<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.sql.*"%>
<%
if (request.getSession().getAttribute("Connection") == null) {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniProject", "root", "root");
	request.getSession().setAttribute("Connection", con);
	Statement statement = con.createStatement();
	request.getSession().setAttribute("Statement", statement);
}

if (request.getSession().getAttribute("userId") == null) {
	request.getRequestDispatcher("login.jsp").forward(request, response);
}
%>


<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/blogs/index.css">
<title>MovieExpert</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	<br>
	<br>
	<div style="position: relative; min-height: 100vh;">


		<div class="container">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-8">
					<div id="carouselExampleCaptions" class="carousel slide"
						data-bs-ride="carousel">
						<div class="carousel-indicators">
							<button type="button" data-bs-target="#carouselExampleCaptions"
								data-bs-slide-to="0" class="active" aria-current="true"
								aria-label="Slide 1"></button>
							<button type="button" data-bs-target="#carouselExampleCaptions"
								data-bs-slide-to="1" aria-label="Slide 2"></button>
							<button type="button" data-bs-target="#carouselExampleCaptions"
								data-bs-slide-to="2" aria-label="Slide 3"></button>
						</div>
						<div class="carousel-inner">
							<div class="carousel-item active">
								<img src="css/blogs/images/carousal1.jpg"
									class="d-block w-100" alt="couldn't load image" width="900"
									height="400">
								<div class="carousel-caption d-none d-md-block"></div>
							</div>
							<div class="carousel-item">
								<img src="css/blogs/images/carousal2.jpg"
									class="d-block w-100" alt="couldn't load image" height="400">
								<div class="carousel-caption d-none d-md-block"></div>
							</div>
							<div class="carousel-item">
								<img src="css/blogs/images/carousal3.jpg"
									class="d-block w-100" alt="couldn't load image" height="400">
								<div class="carousel-caption d-none d-md-block"></div>
							</div>
						</div>
						<button class="carousel-control-prev" type="button"
							data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
							<span class="carousel-control-prev-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Previous</span>
						</button>
						<button class="carousel-control-next" type="button"
							data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Next</span>
						</button>
					</div>
				</div>
				<div class="col-2"></div>
			</div>
		</div>
		<br> <br>
		<div class="container">
			<div class="row">
				<div class="col-4">
					<div class="card" style="width: 18rem;">
						<img
							src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS-7Cb0-kjCjFiwj8z519gbnM7CilqP_RaGsw&usqp=CAU"
							class="card-img-top" alt="...">
						<div class="card-body">
							<p class="card-text">Search any Movie you would like to know
								about</p>
						</div>
					</div>
				</div>
				<div class="col-4">
					<div class="card" style="width: 18rem;">
						<img
							src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSj1cbtHrCxTGHJ4la-6fBeY670i0Drg92lUg&usqp=CAU"
							class="card-img-top" alt="...">
						<div class="card-body">
							<p class="card-text">check out what others have to say about
								movies</p>
						</div>
					</div>
				</div>
				<div class="col-4">
					<div class="card" style="width: 18rem;">
						<img
							src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2rvpulDGut0yOkOa8jWRxr1Uak7s47k9QuQ&usqp=CAU"
							class="card-img-top" alt="...">
						<div class="card-body">
							<p class="card-text">Create Blogs on your Favourite Movies</p>
						</div>
					</div>
				</div>
			</div>
		</div>



	</div>
	<br>
	<br>
	<br>
	<br>
	<jsp:include page="footer.html" />


	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
		integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
		integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
		crossorigin="anonymous"></script>
</body>
</html>