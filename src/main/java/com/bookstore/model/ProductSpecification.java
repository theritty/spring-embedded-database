package com.bookstore.model;

import java.util.Date;

public class ProductSpecification {
	private Integer id;
	private String series_title;
	private String publisher;
	private String book_format;
	private String original_languages;
	private String author;
	private String isbn_13;
	private String isbn_10;
	private Date publication_date;
	private String dimensions;
	private int number_of_pages;

	public ProductSpecification() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSeries_title() {
		return series_title;
	}

	public void setSeries_title(String series_title) {
		this.series_title = series_title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getBook_format() {
		return book_format;
	}

	public void setBook_format(String book_format) {
		this.book_format = book_format;
	}

	public String getOriginal_languages() {
		return original_languages;
	}

	public void setOriginal_languages(String original_languages) {
		this.original_languages = original_languages;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn_13() {
		return isbn_13;
	}

	public void setIsbn_13(String isbn_13) {
		this.isbn_13 = isbn_13;
	}

	public String getIsbn_10() {
		return isbn_10;
	}

	public void setIsbn_10(String isbn_10) {
		this.isbn_10 = isbn_10;
	}

	public Date getPublication_date() {
		return publication_date;
	}

	public void setPublication_date(Date publication_date) {
		this.publication_date = publication_date;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public int getNumber_of_pages() {
		return number_of_pages;
	}

	public void setNumber_of_pages(int number_of_pages) {
		this.number_of_pages = number_of_pages;
	}
}