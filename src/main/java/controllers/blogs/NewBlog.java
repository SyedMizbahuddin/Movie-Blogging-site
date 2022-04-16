package controllers.blogs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewBlog
 */
public class NewBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String title = request.getParameter("title");
		String blog = request.getParameter("blog");
		Integer userId = (Integer) request.getSession().getAttribute("userId");
//		out.println("processing");

		Connection con = (Connection) request.getSession().getAttribute("Connection");
		if (con == null || userId == null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			out.println("con not null");
		}
		Statement statement = (Statement) request.getSession().getAttribute("Statement");
		if (statement == null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			out.println("st not null");
		}
		String query = "insert into blogs(userId,title, blog) values(" + userId + ",'" + title + "','" + blog + "')";
		out.println(query);
		int rowCount;
		try {
			rowCount = statement.executeUpdate(query);

			if (rowCount > 0) {
				request.getRequestDispatcher("MyBlogs").forward(request, response);
			} else {
				out.println("failed");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
