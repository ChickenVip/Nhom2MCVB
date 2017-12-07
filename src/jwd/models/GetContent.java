package jwd.models;

public class GetContent {

	String title,content, name;
	int type;

	public GetContent(String title, String content,String name, int type)
	{

		this.title = title;
		this.content = content;
		this.name = name;
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
