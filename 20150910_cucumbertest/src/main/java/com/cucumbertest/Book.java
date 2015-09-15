package com.cucumbertest;

import java.util.Date;


public class Book {
	private String title;
	public Book(String title2, String author2, Date published2) {
		title = title2;
		author = author2;
		published = published2;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPublished(Date published) {
		this.published = published;
	}
	private String author;
	private Date published;
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public Date getPublished() {
		return published;
	}
 
	// constructors, getter, setter ommitted
}