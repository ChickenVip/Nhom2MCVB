package jwd.models;

import java.sql.Date;

public class NewsEntry {
	int id,type,perid;
	String title,content,coimg;
	Date date;
	public NewsEntry(int id,String title, String content, String coimg, int type, Date date, int perid) {
		super();
		this.id = id;
		this.type = type;
		this.perid = perid;
		this.title = title;
		this.content = content;
		this.coimg = coimg;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getPerid() {
		return perid;
	}
	public void setPerid(int perid) {
		this.perid = perid;
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
	public String getCoimg() {
		return coimg;
	}
	public void setCoimg(String coimg) {
		this.coimg = coimg;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}