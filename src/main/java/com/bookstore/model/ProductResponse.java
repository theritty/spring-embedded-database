package com.bookstore.model;

import java.util.List;

public class ProductResponse extends Product {
	List<Review> reviews;
	ProductSpecification specification;

	String quantityString;

	public ProductResponse(Product product) {
		super(product);

	}

	public ProductSpecification getSpecification() {
		return specification;
	}

	public void setSpecification(ProductSpecification specification) {
		this.specification = specification;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public String getQuantityString() {
		return quantityString;
	}

	public void setQuantityString() {
		this.quantityString = "<select>";
		for(int i=0; i<getRemaining_quantity(); i++) {
			this.quantityString += "<option>" + i + "</option>";
		}
		this.quantityString += "</select>";

		System.out.println(quantityString);
	}


}