package com.qa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String bookTitle;
	private String genre;
	@Size(min = 4, max = 4)
	private String publishYear;

	public Book() {
	}

	public Book(String bookTitle, String genre, String publishYear) {
		this.bookTitle = bookTitle;
		this.genre = genre;
		this.publishYear = publishYear;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublishYear() {
		return publishYear;
	}

	public void setPublishDate(String publishYear) {
		this.publishYear = publishYear;
	}

}
