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

public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignUp() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
//		out.println("processing");
		try {
			Connection con = (Connection) request.getSession().getAttribute("Connection");

			if (con == null) {
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

			String testUserNameQuery = "select userName from users where userName = '" + userName + "'";
			ResultSet rs = statement.executeQuery(testUserNameQuery);
			String status = "signUpSuccess";

			if (rs.next()) {
				status = "userAlreadyExists";
			}

			if (status.equals("userAlreadyExists")) {
				request.setAttribute("status", status);
				request.getRequestDispatcher("status.jsp").forward(request, response);
			}
			String query = "insert into users(userName,userPassword) values('" + userName + "','" + userPassword + "')";
			int rowCount = statement.executeUpdate(query);
			if (rowCount > 0) {
				out.println(status);
				request.setAttribute("status", status);
				request.getRequestDispatcher("status.jsp").forward(request, response);
			} else {
				status = "signUpFailed";
				out.println(status);
				request.setAttribute("status", status);
				request.getRequestDispatcher("status.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

}
