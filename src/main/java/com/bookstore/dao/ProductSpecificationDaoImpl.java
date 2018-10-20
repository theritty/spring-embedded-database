package com.bookstore.dao;

import com.bookstore.helper.Mappers;
import com.bookstore.model.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductSpecificationDaoImpl implements ProductSpecificationDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public ProductSpecification findById(int id) {
		// Gets the reviews of the current product
		Map<String, Object> params3 = new HashMap<>();
		params3.put("spec_id", id);
		String sql3 = "SELECT * FROM product_specifications WHERE id=:spec_id ";
		ProductSpecification result3 = namedParameterJdbcTemplate.queryForObject(sql3, params3,
				(RowMapper<ProductSpecification>) Mappers.getMapper(Mappers.MapType.PRODUCT_SPECIFICATION_MAPPER));

        return result3;
	}

}