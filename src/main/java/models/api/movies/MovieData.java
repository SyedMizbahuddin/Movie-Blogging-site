package models.api.movies;

import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;

public class MovieData {
	private String fullTitle, image, plot, imDbRating;
	private String[] genres;
	private ArrayList<Actor> actorList;
	private BoxOffice boxOffice;
	private ArrayList<MovieCard> similars;
	private JSONObject movieDataJsonObject;

	public MovieData(String movieDataString) {
		movieDataJsonObject = new JSONObject(movieDataString);
		setFullTitle(movieDataJsonObject.getString("fullTitle"));
		setImage(movieDataJsonObject.getString("image"));
		setPlot(movieDataJsonObject.getString("plot"));
		setImDbRating(movieDataJsonObject.getString("imDbRating"));
		setGenres(movieDataJsonObject.getString("genres").split(","));
		setActorList();
		setBoxOffice();
		setSimilars();
	}

	public String getFullTitle() {
		return fullTitle;
	}

	public void setFullTitle(String fullTitle) {
		this.fullTitle = fullTitle;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getImDbRating() {
		return imDbRating;
	}

	public void setImDbRating(String imDbRating) {
		this.imDbRating = imDbRating;
	}

	public String[] getGenres() {
		return genres;
	}

	public void setGenres(String[] genres) {
		this.genres = genres;
	}

	public ArrayList<Actor> getActorList() {
		return actorList;
	}

	public void setActorList() {
		JSONArray actorJsonArray = movieDataJsonObject.getJSONArray("actorList");

		actorList = new ArrayList<Actor>();
		for (int i = 0; i < Math.min(5, actorJsonArray.length()); i++) {
			JSONObject actorJsonObject = actorJsonArray.getJSONObject(i);
			Actor actor = new Actor(actorJsonObject);
			actorList.add(actor);
		}
	}

	public BoxOffice getBoxOffice() {
		return boxOffice;
	}

	public void setBoxOffice() {
		JSONObject boxOfficeJsonObject = movieDataJsonObject.getJSONObject("boxOffice");
		boxOffice = new BoxOffice(boxOfficeJsonObject);
	}

	public ArrayList<MovieCard> getSimilars() {
		return similars;
	}

	public void setSimilars() {
		JSONArray similarsJsonArray = movieDataJsonObject.getJSONArray("similars");

		similars = new ArrayList<MovieCard>();
		for (int i = 0; i < Math.min(4, similarsJsonArray.length()); i++) {
			JSONObject similarsJsonObject = similarsJsonArray.getJSONObject(i);
			MovieCard similarMovieCard = new MovieCard(similarsJsonObject);
			similars.add(similarMovieCard);
		}
	}

	@Override
	public String toString() {
		return "MovieData [fullTitle=" + fullTitle + ", image=" + image + ", plot=" + plot + ", imDbRating="
				+ imDbRating + ", genres=" + Arrays.toString(genres) + ", actorList=" + actorList + ", boxOffice="
				+ boxOffice + ", similars=" + similars + ", movieDataJsonObject=" + movieDataJsonObject + "]";
	}

}