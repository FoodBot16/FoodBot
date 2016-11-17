package org.foodbot.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.foodbot.domain.ChatVO;
import org.foodbot.domain.MemberVO;
import org.foodbot.service.ChatService;
import org.foodbot.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/*
 * 채팅 컨트롤러 
 * - 채팅 창
 * 
 */
@Controller
@RequestMapping("/chat/*")
public class ChatController {
	
	@Inject
	private MemberService service;
	@Inject 
	private ChatService chatService;
	
	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
	
	@RequestMapping(value = "/chat", method=RequestMethod.GET)
	public void viewChatPage() {
		logger.info("viewChatPage get...");
		
	}
	
	@RequestMapping("/chat-ws")
    public void viewPaintingPage() throws Exception {
		
	
    }
	@RequestMapping("/chatting")
    public void viewPaintingPage2() {
    }
}
