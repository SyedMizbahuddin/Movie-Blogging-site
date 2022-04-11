package controllers.blogs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.blogs.Blog;

public class Blogs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// TODO Auto-generated method stub
//		int userId = request.getSession().getAttribute("userId");
		Connection con = (Connection) request.getSession().getAttribute("Connection");
		try {
			Statement statement = con.createStatement();
			String query = "select title, blog from blogs order by blogId desc limit 5";
			ResultSet result = statement.executeQuery(query);
			ArrayList<Blog> blogsResult = new ArrayList();
			while (result.next()) {
				blogsResult.add(new Blog(result));
			}
			request.setAttribute("blogsResult", blogsResult);
			request.getRequestDispatcher("views/blogs/blogs.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
