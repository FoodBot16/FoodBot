package org.foodbot.controller;

import javax.inject.Inject;

import org.foodbot.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/include/*")
public class IncludeController {
	private static final Logger logger = LoggerFactory.getLogger(IncludeController.class);
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/header", method=RequestMethod.GET)
	public void header() throws Exception {
		logger.info("header");
	}
	
	@RequestMapping(value="/footer", method=RequestMethod.GET)
	public void footer() throws Exception {
		logger.info("footer");
	}
	
}
