package com.bookstore.dao;

import com.bookstore.model.Product;

import java.util.List;

public interface StoreDao {

	List<Product> findProductsOfPage(int page);
	Integer findCountOfProducts();
}