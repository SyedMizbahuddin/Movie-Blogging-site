package controllers.blogs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		out.println("processing");

		int userId = -1;
		try {
			Connection con = (Connection) request.getSession().getAttribute("Connection");
//			if (con == null) {
//				out.println("connection is null");
//			} else {
//				out.println("ok");
//			}
			Statement statement = (Statement) request.getSession().getAttribute("Statement");
			String query = "select userId from users where userName = '" + userName + "' and userPassword = '"
					+ userPassword + "'";
			out.println(query);
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				userId = result.getInt("userId");
			}
			if (userId == -1) {
//				out.println("no id");
			} else {
				out.println(userId);
				request.getSession().setAttribute("userId", userId);
				response.sendRedirect("index.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
