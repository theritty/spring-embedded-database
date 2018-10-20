package com.bookstore.dao;

import com.bookstore.helper.Mappers;
import com.bookstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductDaoImpl implements ProductDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	ReviewDao reviewDao;

	@Autowired
	ProductSpecificationDao productSpecificationDao;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public Product findById(int id) {


		// Gets the detail of the current product by its id.
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		String sql = "SELECT * FROM products WHERE id=:id";
		return namedParameterJdbcTemplate.queryForObject(
				sql, params, (RowMapper<Product>) Mappers.getMapper(Mappers.MapType.PRODUCT_MAPPER));
        
	}

}