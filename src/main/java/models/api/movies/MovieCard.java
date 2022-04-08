package models.api.movies;

import org.json.JSONObject;

public class MovieCard {
	private String image, title, id;

	public MovieCard(JSONObject movieResult) {
		setTitle(movieResult.getString("title"));
		setImage(movieResult.getString("image"));
		setId(movieResult.getString("id"));
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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
