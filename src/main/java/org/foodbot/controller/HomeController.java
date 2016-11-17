package org.foodbot.controller;

import java.util.Locale;

import javax.inject.Inject;

import org.foodbot.mlp.HyperParameter;
import org.foodbot.service.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	HyperParameter hp;
	@Inject
	FoodService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
	
		
		return "home";
	}
		
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void main(Locale locale, Model model) {
		logger.info("main page");
		
	}
	
}
