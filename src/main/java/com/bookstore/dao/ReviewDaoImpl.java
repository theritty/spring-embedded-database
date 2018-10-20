package com.bookstore.dao;

import com.bookstore.helper.Mappers;
import com.bookstore.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ReviewDaoImpl implements ReviewDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public List<Review> findById(int id) {

		// Gets the reviews of the current product
		Map<String, Object> params2 = new HashMap<>();
		params2.put("product_id", id);
        String sql2 = "SELECT reviews.text, customers.name FROM reviews " +
				"INNER JOIN customers ON reviews.customer_id=customers.id " +
				"WHERE reviews.product_id=:product_id ";
		List<Review> result2 = namedParameterJdbcTemplate.query(sql2, params2,
				(RowMapper<Review>) Mappers.getMapper(Mappers.MapType.REVIEW_MAPPER));

        return result2;
        
	}

}