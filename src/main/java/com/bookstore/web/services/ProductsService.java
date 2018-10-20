package com.bookstore.web.services;

import com.bookstore.dao.ProductDao;
import com.bookstore.dao.ProductSpecificationDao;
import com.bookstore.dao.ReviewDao;
import com.bookstore.model.Product;
import com.bookstore.model.ProductResponse;
import com.bookstore.model.ProductSpecification;
import com.bookstore.model.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

	private static final Logger logger = LoggerFactory.getLogger(ProductsService.class);

	@Autowired
	ProductDao productDao;
	@Autowired
	ProductSpecificationDao productSpecificationDao;
	@Autowired
	ReviewDao reviewDao;

	public ProductResponse findById(int id) {

		// Gets the detail of the current product by its id.
		Product result = productDao.findById(id);

		// Gets the reviews of the current product
		List<Review> result2 = reviewDao.findById(id);

		// Gets the reviews of the current product
		ProductSpecification result3 = productSpecificationDao.findById(result.getSpec_id());

		// Concatenates the information received by previous two commands and redirects to view.
		ProductResponse response = new ProductResponse(result);
		response.setReviews(result2);
		response.setSpecification(result3);
		response.setQuantityString();
		return response;

	}

}