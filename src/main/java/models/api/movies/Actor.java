package models.api.movies;

import org.json.JSONObject;

public class Actor {
	private String image, name, asCharacter;

	public Actor(JSONObject actorJsonObject) {
		setName(actorJsonObject.getString("name"));
		setImage(actorJsonObject.getString("image"));
		setAsCharacter(actorJsonObject.getString("asCharacter"));
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAsCharacter() {
		return asCharacter;
	}

	public void setAsCharacter(String asCharacter) {
		String[] strName = asCharacter.split(" ");
		this.asCharacter = "";
		for (int i = 0; i < Math.min(2, strName.length); i++) {
			this.asCharacter = this.asCharacter + " " + strName[i];
		}
	}

}
