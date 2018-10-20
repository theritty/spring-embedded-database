package com.bookstore.dao;

import com.bookstore.model.Product;
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

import java.util.List;

public class ReviewDaoTest {

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
    public void testGetReviews() {
    	NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
    	ReviewDaoImpl reviewDao = new ReviewDaoImpl();
		reviewDao.setNamedParameterJdbcTemplate(template);

		List<Review> reviews = reviewDao.findById(1);
		Assertions
				.assertThat(reviews)
				.hasSize(4);

		Assert.assertNotNull(reviews.get(0));
        Assert.assertEquals(1, reviews.get(0).getId().intValue());
        Assert.assertEquals("Jane Doe", reviews.get(0).getCustomer_name());
        Assert.assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce elementum dignissim mauris, et gravida felis eleifend euismod.", reviews.get(0).getText());
    }

    @After
    public void tearDown() {
        db.shutdown();
    }

}