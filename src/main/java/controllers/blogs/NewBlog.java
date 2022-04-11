package controllers.blogs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
		int userId = (Integer) request.getSession().getAttribute("userId");
//		out.println("processing");
		try {
			Connection con = (Connection) request.getSession().getAttribute("Connection");
			if (con == null) {
				out.println("connection is null");
			} else {
				out.println("con not null");
			}
			Statement statement = (Statement) request.getSession().getAttribute("Statement");
			if (statement == null) {
				out.println("st null");
			} else {
				out.println("st not null");
			}
			String query = "insert into blogs(userId,title, blog) values(" + userId + ",'" + title + "','" + blog
					+ "')";
			out.println(query);
//			File f1 = new File("insertions.txt");
//			if (!f1.exists()) {
//				out.println("entered");
//				f1.createNewFile();
//			}
//			FileWriter fileWritter = new FileWriter(f1.getName(), true);
//			BufferedWriter bw = new BufferedWriter(fileWritter);
//			bw.write(query);
			int rowCount = statement.executeUpdate(query);
			if (rowCount > 0) {
				out.println("done");
				response.sendRedirect("login.jsp");
			} else {
				out.println("failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

}
