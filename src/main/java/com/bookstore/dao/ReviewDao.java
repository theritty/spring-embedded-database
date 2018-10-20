package com.bookstore.dao;

import com.bookstore.model.Review;

import java.util.List;

public interface ReviewDao {

	List<Review> findById(int id);

}