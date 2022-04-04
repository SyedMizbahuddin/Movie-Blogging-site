package controllers.api.movies;

import org.json.JSONObject;

public class MovieCard {
	private String image, title, id;

	MovieCard(JSONObject Movie) {
		setTitle(Movie.getString("title"));
		setImage(Movie.getString("image"));
		setId(Movie.getString("id"));
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = "<h3>" + title + "</h3>";
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = "<img src = " + image + " >";
		// this.image = image;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "MovieCard [image=" + image + ", title=" + title + ", id=" + id + "]";
	}

	public void setId(String id) {
		this.id = id;
	}

}
