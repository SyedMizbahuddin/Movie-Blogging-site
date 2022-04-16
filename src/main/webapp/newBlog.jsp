
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
<link rel="stylesheet" type="text/css" href="css/blogs/newblog.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div style="position: relative; min-height: 100vh;">


		<div>
		<br>
		<br>
			<form method="get" action="NewBlog">

				<div class="wrapper">
					<h3>Title</h3>
					<input class="title" type="text" name="title"
						placeholder="title...">
				</div>

				<div class="wrapper">
					<h3>Blog</h3>
					<textarea name="blog" id="the-textarea" maxlength="200"
						placeholder="Start Typin..."></textarea>
					<div id="the-count">
						<span id="current">0</span> <span id="maximum">/ 200</span>
					</div>
				</div>
				<div class="wrapper">

					<input type="submit" class="submit" name="submit" value="Create">
				</div>
			</form>
		</div>



	</div>

	<jsp:include page="footer.html" />
	<script type="text/javascript">
		var textarea = document.querySelector("textarea");

		textarea.addEventListener("input", function() {
			var maxlength = this.getAttribute("maxlength");
			var currentLength = this.value.length;

			document.getElementById('current').innerHTML = currentLength;
		});
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>