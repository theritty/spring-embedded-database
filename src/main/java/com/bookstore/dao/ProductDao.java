package com.bookstore.dao;

import com.bookstore.model.Product;

public interface ProductDao {

	Product findById(int id);

}