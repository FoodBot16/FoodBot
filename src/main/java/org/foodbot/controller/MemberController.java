package org.foodbot.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.foodbot.domain.ChatVO;
import org.foodbot.domain.MemberVO;
import org.foodbot.dto.LoginDTO;
import org.foodbot.service.ChatService;
import org.foodbot.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Inject
	private MemberService service;
	@Inject 
	private ChatService chatService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public void loginPOST(@ModelAttribute("dto") LoginDTO dto, HttpSession session, Model model) throws Exception {
		logger.info("loginPOST ...");
		
		MemberVO vo = service.login(dto);
		List<ChatVO> chatList = (List<ChatVO>)chatService.read(dto.getUid());
		logger.info(vo.getUid());
	
		if(vo == null) {
			return;
		}
		model.addAttribute("memberVO",vo);
		model.addAttribute("chatList",chatList);
		
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout( HttpSession session) throws Exception {
		logger.info("logout ...");
		
		session.invalidate();
		
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String regist(@ModelAttribute("vo") MemberVO vo,Model model) throws Exception {
		logger.info("regist ...");
		
		service.regist(vo);
		
		LoginDTO dto = new LoginDTO();
		dto.setUid(vo.getUid());
		dto.setUid(vo.getPassword());
		service.login(dto);
		
		if(vo == null) {
			return null;
		}
		model.addAttribute("memberVO",vo);
		
		return "redirect:/";
	}
	
}
