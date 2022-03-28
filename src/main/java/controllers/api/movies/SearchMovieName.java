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

import org.json.JSONArray;
import org.json.JSONObject;

public class SearchMovieName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchMovieName() {
		super();
	}

	PrintWriter out;

	HttpServletRequest request;
	HttpServletResponse response;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.request = request;
		this.response = response;
		String inputMovieName = request.getParameter("inputMovieName");
		inputMovieName = refractor(inputMovieName);
		String outputMovieName = getMovieFromAPI(inputMovieName);

		out = response.getWriter();
		response.setContentType("text/html");

		parse(outputMovieName);

//		out.println(outputMovieName);
	}

	public String refractor(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				sb.append("%20");
			else
				sb.append(str.charAt(i));
		}
		return sb.toString();
	}

	// https://imdb-api.com/en/API/SearchMovie/k_i6u6ejxk/inception 2010
	String getMovieFromAPI(String inputMovieName) {

		String url = "https://imdb-api.com/en/API/SearchMovie/k_i6u6ejxk/" + inputMovieName;
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

	void parse(String outputMovieName) {
		JSONObject movie = new JSONObject(outputMovieName);

		JSONArray resultsArray = movie.getJSONArray("results");

		for (int i = 0; i < Math.min(5, resultsArray.length()); i++) {
			JSONObject movieResult = resultsArray.getJSONObject(i);
			MovieCard resultMovieCard = new MovieCard(movieResult);
			request.setAttribute("movieCard", resultMovieCard);
			try {
				request.getRequestDispatcher("MovieCard.jsp").include(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return;
	}

}