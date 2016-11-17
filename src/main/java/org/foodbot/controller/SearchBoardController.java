package org.foodbot.controller;

import javax.inject.Inject;

import org.foodbot.domain.BoardVO;
import org.foodbot.domain.PageMaker;
import org.foodbot.domain.SearchCriteria;
import org.foodbot.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {
	private static final Logger  logger = LoggerFactory.getLogger(SearchBoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void registGET() throws Exception {
		logger.info("regist get ...");
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST) 
	public String registPOST(BoardVO board, RedirectAttributes attr) throws Exception {
		service.regist(board);
		attr.addFlashAttribute("result","success");
		return "redirect:/sboard/list";
	} 
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri,
						Model model) throws Exception {
		logger.info("list get .......");
		logger.info(cri.toString());
		
//		model.addAttribute("list",service.listCriteria(cri));
		model.addAttribute("list",service.listSearchCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
//		pageMaker.setTotalCount(service.listCountCriteria(cri));
		pageMaker.setTotalCount(service.listSearchCount(cri));
		model.addAttribute("pageMaker",pageMaker);
	}
	
	@RequestMapping(value="/simpleList", method=RequestMethod.GET)
	public void listPageSimple(@ModelAttribute("cri") SearchCriteria cri,
						Model model) throws Exception {
		logger.info("simplelist get .......");
		logger.info(cri.toString());
		
		model.addAttribute("list",service.listSearchCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));
		model.addAttribute("pageMaker",pageMaker);
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void read(@RequestParam("bno")int bno,
					@ModelAttribute("cri") SearchCriteria cri,
					Model model) throws Exception {
		
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@RequestParam("bno")int bno, 
						SearchCriteria cri,
						RedirectAttributes attr ) throws Exception {
		
		service.remove(bno);
		
		attr.addAttribute("page",cri.getPage());
		attr.addAttribute("perPageNum",cri.getPerPageNum());
		attr.addAttribute("searchType",cri.getSearchType());
		attr.addAttribute("keyword",cri.getKeyword());
		
		attr.addFlashAttribute("result","success");
		return "redirect:/sboard/list";
	}

	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public void modifyPageGET(@RequestParam("bno")int bno,
						@ModelAttribute("cri")SearchCriteria cri,
						Model model) throws Exception {	
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modifyPagePOST(BoardVO board, SearchCriteria cri, RedirectAttributes attr) throws Exception {
		service.modify(board);
		
		attr.addAttribute("page",cri.getPage());
		attr.addAttribute("perPageNum",cri.getPerPageNum());
		attr.addAttribute("searchType",cri.getSearchType());
		attr.addAttribute("keyword",cri.getKeyword());
		attr.addFlashAttribute("result","success");
		logger.info("modifypage post .......");
		
		
		return "redirect:/sboard/list";
		
	}
	
}
