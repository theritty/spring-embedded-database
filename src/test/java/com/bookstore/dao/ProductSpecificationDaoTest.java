package com.bookstore.dao;

import com.bookstore.model.Product;
import com.bookstore.model.ProductSpecification;
import com.bookstore.model.Review;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProductSpecificationDaoTest {

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
	public void testGetProductSpecs() {
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
		ProductSpecificationDaoImpl productSpecificationDao = new ProductSpecificationDaoImpl();
		productSpecificationDao.setNamedParameterJdbcTemplate(template);

		ProductSpecification spec = productSpecificationDao.findById(1);


		Assert.assertEquals(1, spec.getId().intValue());
		Assert.assertEquals(336, spec.getNumber_of_pages());
		Assert.assertEquals("154326542", spec.getIsbn_13());
		Assert.assertEquals("ATWOOD, MARGARET", spec.getAuthor());
		Assert.assertEquals("Anchor Books", spec.getSeries_title());
		Assert.assertEquals("Knopf Doubleday Publishing Group", spec.getPublisher());
		Assert.assertEquals("Hardcover", spec.getBook_format());
		Assert.assertEquals("English", spec.getOriginal_languages());
		Assert.assertEquals("5.10 x 0.80 x 7.90 Inches", spec.getDimensions());
		Assert.assertEquals("349324X", spec.getIsbn_10());
		try {
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2016-01-02");
			Assert.assertEquals(date1, spec.getPublication_date());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

    @After
    public void tearDown() {
        db.shutdown();
    }

}