<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/blogs/blog.css">
</head>
<body>
<c:forEach var = "Blog" items = "${blogsResult}">

	<div class = "container">
	<div class = "box">
		
	<article class="blog-post">
        <h2 class="blog-post-title">${Blog.getTitle()}</h2>
		<!--  <ul class = "tags">
          <li>First list item</li>
          <li>Second list item with a longer description</li>
          <li>Third list item to close it out</li>
        </ul>-->
        
        <p>${Blog.getBlog()}</p>
        
      </article>
	</div>
	</div>
	</c:forEach>
	
</body>
</html>