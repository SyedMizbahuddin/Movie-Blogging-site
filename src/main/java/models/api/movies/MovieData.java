package models.api.movies;

import java.util.ArrayList;

public class MovieData {
	private String fullTitle, image, releaseDate, runtimeStr, plot, imDbRating, metacriticRating;
	private String[] genres;
	private ArrayList<Actor> actorList;
	private ArrayList<Director> directorList;
	private BoxOffice boxOffice;
	private ArrayList<MovieCard> similars;

	public MovieData() {
		// TODO Auto-generated constructor stub

	}
}