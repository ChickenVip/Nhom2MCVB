package jwd.models;

public class GetTitleFull {

	String id, title, coimg, name, date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCoimg() {
		return coimg;
	}

	public void setCoimg(String coimg) {
		this.coimg = coimg;
	}


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public GetTitleFull(String id,String title,String coimg,String name,String date)
	{
		this.id = id;
		this.title= title;
		this.coimg = coimg;
		this.name = name;
		this.date = date;
	}
}
