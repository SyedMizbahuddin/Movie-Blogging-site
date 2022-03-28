package controllers.api.movies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MovieData
 */
public class SearchMovieData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchMovieData() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String inputMovieID = request.getParameter("inputMovieID");

		out.println(inputMovieID);
	}

}
