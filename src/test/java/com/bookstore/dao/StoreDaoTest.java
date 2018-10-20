package com.bookstore.dao;

import com.bookstore.model.Product;
import com.bookstore.model.StoreResponse;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.List;

public class StoreDaoTest {

    private EmbeddedDatabase db;

    @Before
    public void setUp() {
    	db = new EmbeddedDatabaseBuilder()
    		.setType(EmbeddedDatabaseType.HSQL)
    		.addScript("db/sql/create-db.sql")
    		.addScript("db/sql/insert-data.sql")
    		.build();
    }
	@Test
	public void testProductsPage1() {
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
		StoreDaoImpl storeDao = new StoreDaoImpl();
		storeDao.setNamedParameterJdbcTemplate(template);

		List<Product> products = storeDao.findProductsOfPage(1);

		Assert.assertNotNull(products);
		Assertions
				.assertThat(products)
				.hasSize(20);
	}
	@Test
	public void testProductsPage2() {
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
		StoreDaoImpl storeDao = new StoreDaoImpl();
		storeDao.setNamedParameterJdbcTemplate(template);

		List<Product> products = storeDao.findProductsOfPage(2);

		Assert.assertNotNull(products);
		Assertions
				.assertThat(products)
				.hasSize(19);
	}

    @After
    public void tearDown() {
        db.shutdown();
    }

}