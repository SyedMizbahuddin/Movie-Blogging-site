package models.blogs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Blog {
	String title, blog;

	public Blog(ResultSet row) throws SQLException {
		setTitle(row.getString("title"));
		setBlog(row.getString("blog"));
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	@Override
	public String toString() {
		return "Blog [title=" + title + ", blog=" + blog + "]";
	}

}
