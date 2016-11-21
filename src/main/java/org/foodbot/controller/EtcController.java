package org.foodbot.controller;

import javax.inject.Inject;

import org.foodbot.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */

@Controller
@RequestMapping("/etc/*")
public class EtcController {
	private static final Logger logger = LoggerFactory.getLogger(EtcController.class);
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/privacy", method=RequestMethod.GET)
	public void qna() throws Exception {
		logger.info("privacy");
	}
	
	
}
