package com.imarticus.tutorial.dtos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table
public class Book{
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Book{");
		sb.append("id:").append(id).append(",");
		sb.append("title:").append(title).append(",");
		sb.append("price:").append(price).append(",");
		sb.append("author:").append(author).append(",");
		sb.append("category:").append(category).append(",");
		sb.append("publishYear:").append(publishYear).append(",");
		sb.append("availableCopies:").append(availableCopies).append(",");
		sb.append("totalCopies:").append(totalCopies).append("");
		sb.append("}");
		
		return sb.toString();
	}
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	Long id;

	public Long getId() {
		return id;
	}
	@ApiModelProperty(example = "Swagger Basics")	
	String title;
	
	@ApiModelProperty(example = "410")
	double price;
	
	@ApiModelProperty(example = "Imarticus")
	String author;
	
	@ApiModelProperty(example = "Software")
	String category;
	
	@ApiModelProperty(example = "2019")
	int publishYear;
	
	@ApiModelProperty(example = "25")
	int availableCopies;
	
	@ApiModelProperty(example = "25")
	int totalCopies;
	
	@ApiModelProperty(example = "")
	String imageUrl;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPublishYear() {
		return publishYear;
	}
	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	public int getAvailableCopies() {
		return availableCopies;
	}
	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}
	public int getTotalCopies() {
		return totalCopies;
	}
	public void setTotalCopies(int totalCopies) {
		this.totalCopies = totalCopies;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public Book() {
		
	}

	public void setId(Long id) {
		this.id = id;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	public Book(String title, double price, String author, String category, int publishYear, int totalCopies, String imageUrl) {
		super();
		this.title = title;
		this.price = price;
		this.author = author;
		this.category = category;
		this.publishYear = publishYear;
		this.availableCopies = totalCopies;
		this.totalCopies = totalCopies;
		this.imageUrl = imageUrl;
	}
	
	public Book(String title, double price, String author, String category, int publishYear, int availableCopies,
			int totalCopies, String imageUrl) {
		super();
		this.title = title;
		this.price = price;
		this.author = author;
		this.category = category;
		this.publishYear = publishYear;
		this.availableCopies = availableCopies;
		this.totalCopies = totalCopies;
		this.imageUrl = imageUrl;
	}

	
	
	
	


}
	
