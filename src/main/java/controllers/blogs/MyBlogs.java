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

/**
 * Servlet implementation class MyBlogs
 */
public class MyBlogs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Connection con = (Connection) request.getSession().getAttribute("Connection");
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		if (con == null || userId == null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			out.println("con not null");
		}
		try {
			Statement statement = (Statement) request.getSession().getAttribute("Statement");

			if (statement == null) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				out.println("st not null");
			}
			String query = "select title, blog from blogs where userId = " + userId + " order by blogId desc limit 5";
			out.println(query);
			ResultSet result = statement.executeQuery(query);
			ArrayList<Blog> blogsResult = new ArrayList();
			while (result.next()) {
				blogsResult.add(new Blog(result));
			}
			request.setAttribute("blogsResult", blogsResult);
			request.getRequestDispatcher("views/blogs/blogs.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
