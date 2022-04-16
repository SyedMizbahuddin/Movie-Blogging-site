package controllers.api.movies;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import models.api.movies.MovieCard;

public class SearchMovieName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchMovieName() {
		super();
	}

	PrintWriter out;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String inputMovieName = request.getParameter("inputMovieName");
		inputMovieName = refractor(inputMovieName);

		out = response.getWriter();

		String outputMovieName = getMovieFromAPI(inputMovieName);
		out.println(outputMovieName);
		ArrayList<MovieCard> resultMovieCards = parse(outputMovieName);
		request.setAttribute("resultMovieCards", resultMovieCards);

		try {
			request.getRequestDispatcher("views/api/movies/MovieCard.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		String key = "k_i6u6ejxk/";
		// key = "k_upvdu2lz/";
//		key = "k_96cn8h5v/";
		String url = "https://imdb-api.com/en/API/SearchMovie/" + key + inputMovieName;
		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		HttpClient client = HttpClient.newBuilder().build();
		HttpResponse<String> response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		out.println(response.statusCode());
		out.println(url);
		// System.out.println(response.body());
		return response.body().toString();
	}

	ArrayList<MovieCard> parse(String outputMovieName) {
		JSONObject movie = new JSONObject(outputMovieName);

		JSONArray resultsArray = movie.getJSONArray("results");

		ArrayList<MovieCard> resultMovieCards = new ArrayList<MovieCard>();

		for (int i = 0; i < Math.min(8, resultsArray.length()); i++) {
			JSONObject movieResult = resultsArray.getJSONObject(i);
			MovieCard resultMovieCard = new MovieCard(movieResult);
			resultMovieCards.add(resultMovieCard);
		}

		return resultMovieCards;
	}

}