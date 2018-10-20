package com.bookstore.dao;

import com.bookstore.helper.Mappers;
import com.bookstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StoreDaoImpl implements StoreDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public List<Product> findProductsOfPage(int page) {

		// Following gets the list of products for he given page containing the following fields: id, name, price, discount
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("offset", (page-1)*20);
		String sql = "SELECT id, name, price, discount, picture_url FROM products " +
				"ORDER BY id OFFSET :offset FETCH  NEXT 20 ROWS ONLY";
        return namedParameterJdbcTemplate.query(sql, params,
				(RowMapper<Product>) Mappers.getMapper(Mappers.MapType.SIMPLIFIED_PRODUCT_MAPPER));
	}


	@Override
	public Integer findCountOfProducts() {
		// Gets the total number of products saved into db
		// Then finds the number of pages which will be shown on view
		String sql2 = "SELECT count(*) FROM products";
		Map<String, Object> params2 = new HashMap<String, Object>();
		return namedParameterJdbcTemplate.queryForObject(sql2, params2, Integer.class);
	}

}