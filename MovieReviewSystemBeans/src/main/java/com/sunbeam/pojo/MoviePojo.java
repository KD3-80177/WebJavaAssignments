package com.sunbeam.pojo;

import java.util.*;
public class MoviePojo {
	private int id;

	private String title;
	private String release_date;
	public MoviePojo() {
		super();
	}
	public MoviePojo(String title, String r_date) {
		super();
		this.title = title;
		this.release_date = r_date;
	}
	
	public MoviePojo(int id, String title, String r_date) {
		super();
		this.id = id;
		this.title = title;
		this.release_date = r_date;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getR_date() {
		return release_date;
	}
	public void setR_date(String r_date) {
		this.release_date = r_date;
	}
	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", release_date=" + release_date + "]";
	}
}
