package com.bookstore.web.controller;

import com.bookstore.model.Product;
import com.bookstore.web.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductsController {

	@Autowired
	ProductsService productsService;

	@RequestMapping("getProductById/{id}")
	public ModelAndView getProductById(@PathVariable(value = "id") String id) {
		Product product = productsService.findById(Integer.parseInt(id));
		return new ModelAndView("product", "productObj", product);
	}

}