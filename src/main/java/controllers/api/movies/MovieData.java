package controllers.api.movies;

import org.json.JSONObject;

public class MovieData {
	private String title, year, image, releaseDate, plot;

	MovieData(JSONObject Movie) {
		setTitle(Movie.getString("title"));
		setYear(Movie.getString("year"));
		setImage(Movie.getString("image"));
		setReleaseDate(Movie.getString("releaseDate"));
		setPlot(Movie.getString("plot"));
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = "<h3>" + title + "</h3>";
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = "<img src = " + image + " >";
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}
}
