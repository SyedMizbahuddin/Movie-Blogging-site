package models.api.movies;

import org.json.JSONObject;

public class BoxOffice {
	private String budget, cumulativeWorldwideGross;

	public BoxOffice(JSONObject boxOfficeJsonObject) {
		setBudget(boxOfficeJsonObject.getString("budget"));
		setCumulativeWorldwideGross(boxOfficeJsonObject.getString("cumulativeWorldwideGross"));
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getCumulativeWorldwideGross() {
		return cumulativeWorldwideGross;
	}

	public void setCumulativeWorldwideGross(String cumulativeWorldwideGross) {
		this.cumulativeWorldwideGross = cumulativeWorldwideGross;
	}
}
