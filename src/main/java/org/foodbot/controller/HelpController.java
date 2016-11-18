package org.foodbot.controller;

import javax.inject.Inject;

import org.foodbot.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/help/*")
public class HelpController {
	private static final Logger logger = LoggerFactory.getLogger(HelpController.class);
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/qna", method=RequestMethod.GET)
	public void qna() throws Exception {
		logger.info("qna");
	}
	

	@RequestMapping(value="/contact", method=RequestMethod.GET)
	public void contact() throws Exception {
		logger.info("contact");
	}
	
}
