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
			if (con == null) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				out.println("ok");
			}
			Statement statement = (Statement) request.getSession().getAttribute("Statement");
			if (statement == null) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				out.println("st not null");
			}
			String query = "select userId from users where userName = '" + userName + "' and userPassword = '"
					+ userPassword + "'";
			out.println(query);
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				userId = result.getInt("userId");
			}
			if (userId == -1) {
				String status = "loginFailed";
				request.setAttribute("status", status);
				request.getRequestDispatcher("status.jsp").forward(request, response);
			} else {
				out.println(userId);
				request.getSession().setAttribute("userId", userId);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
