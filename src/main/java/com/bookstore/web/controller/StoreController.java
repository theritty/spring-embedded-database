package com.bookstore.web.controller;

import com.bookstore.model.StoreResponse;
import com.bookstore.web.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StoreController {

	@Autowired
	StoreService storeService;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView products() {
		StoreResponse storeResponse = storeService.getProductsOfPage(1);
		return new ModelAndView("store", "storeResponse", storeResponse);
	}


	@RequestMapping(value = "/products/{page}", method = RequestMethod.GET)
	public ModelAndView products(@PathVariable(value = "page") String page) {
		StoreResponse storeResponse = storeService.getProductsOfPage(Integer.parseInt(page));
		return new ModelAndView("store", "storeResponse", storeResponse);
	}

}