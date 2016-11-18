package org.foodbot.controller;

import javax.inject.Inject;

import org.foodbot.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/about/*")
public class AboutController {
	private static final Logger logger = LoggerFactory.getLogger(AboutController.class);
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/intro", method=RequestMethod.GET)
	public void myInfo() throws Exception {
		logger.info("allInfo get ...");
	}
}
