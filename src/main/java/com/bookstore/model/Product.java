package com.bookstore.model;

public class Product {
	private Integer id;

	private String name;

	private String description;

	private Integer category_id;

	private Integer spec_id;

	private Double price;

	private Double discount;

	private boolean is_best_seller;

	private boolean is_new;

	private String picture_url;

	private Integer remaining_quantity;

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description +
				", category_id=" + category_id + ", price=" + price + ", discount=" + discount + ", is_best_seller=" + is_best_seller +
				", is_new=" + is_new +", picture_url=" + picture_url +", remaining_quantity=" + remaining_quantity +"]";
	}

	public Product() {
	}

	public Product(Product product) {
		this.id = product.id;
		this.name = product.name;
		this.description = product.description;
		this.category_id = product.category_id;
		this.price = product.price;
		this.discount = product.discount;
		this.is_best_seller = product.is_best_seller;
		this.is_new = product.is_new;
		this.picture_url = product.picture_url;
		this.remaining_quantity = product.remaining_quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public Integer getSpec_id() {
		return spec_id;
	}

	public void setSpec_id(Integer spec_id) {
		this.spec_id = spec_id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public boolean isIs_best_seller() {
		return is_best_seller;
	}

	public void setIs_best_seller(boolean is_best_seller) {
		this.is_best_seller = is_best_seller;
	}

	public boolean isIs_new() {
		return is_new;
	}

	public void setIs_new(boolean is_new) {
		this.is_new = is_new;
	}

	public String getPicture_url() {
		return picture_url;
	}

	public void setPicture_url(String picture_url) {
		this.picture_url = picture_url;
	}

	public Integer getRemaining_quantity() {
		return remaining_quantity;
	}

	public void setRemaining_quantity(Integer remaining_quantity) {
		this.remaining_quantity = remaining_quantity;
	}


}