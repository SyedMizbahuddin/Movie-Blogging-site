package controllers.api.movies;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		String outputMovieData = getMovieDataFromAPI(inputMovieID);
		out.println("hiii");
		out.println(outputMovieData);

	}

	// https://imdb-api.com/en/API/Title/k_i6u6ejxk/
	String getMovieDataFromAPI(String inputMovieID) {

		String url = "https://imdb-api.com/en/API/Title/k_i6u6ejxk/" + inputMovieID;

		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		HttpClient client = HttpClient.newBuilder().build();
		HttpResponse response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// System.out.println(response.statusCode());
		// System.out.println(response.body());
		return response.body().toString();
	}
}
