package com.bookstore.model;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StoreResponse {
	List<List<Product>> products;
	List<Integer> pages;
	int numRows = 0;
	int currentPage = 0;

	public StoreResponse(List<Product> products, int pageNum, int numRows, int currentPage) {
		this.products = Lists.partition(products, 4);
		this.pages = IntStream.range(1, pageNum+1).boxed().collect(Collectors.toList());
		this.numRows = numRows;
		this.currentPage = currentPage;
	}

	public List<List<Product>> getProducts() {
		return products;
	}

	public void setProducts(List<List<Product>> products) {
		this.products = products;
	}

	public int getNumRows() {
		return numRows;
	}

	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}

	public List<Integer> getPages() {
		return pages;
	}

	public void setPages(List<Integer> pages) {
		this.pages = pages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
}