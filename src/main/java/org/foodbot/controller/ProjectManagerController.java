package org.foodbot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.foodbot.domain.FoodVO;
import org.foodbot.domain.IngredVO;
import org.foodbot.domain.MorpVO;
import org.foodbot.domain.TasteVO;
import org.foodbot.mlp.InitTrain;
import org.foodbot.mlp.InitTrainData;
import org.foodbot.service.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * 관리자 전용
 * 초기 DB 음식 데이터  처리 컨트롤러
 */
@Controller
@RequestMapping("/manage/*")
public class ProjectManagerController {
	private static final Logger logger = LoggerFactory.getLogger(ProjectManagerController.class);
	
	@Inject
	private FoodService service;
	
	@RequestMapping(value="/ingred", method=RequestMethod.GET)
	public void insertIngredGET() throws Exception {
		logger.info("insertIngred get ...");
	}
	
	@RequestMapping(value="/ingred", method=RequestMethod.POST)
	public void insertIngredPOST(@ModelAttribute("ingred") String str) throws Exception {
		logger.info("insertIngred POST ...");
		
		IngredVO in = null;
		List<IngredVO> ingredList = new ArrayList<IngredVO>();
		String[] k = str.split("\n");
		for(int i=0 ;i<k.length ; i++) {
			String[] k2 = k[i].split("\t");
			in = new IngredVO();
			in.setIngred(k2[0]);
			in.setIngred_code(k2[1]);
			ingredList.add(in);
			in=null;	

		}
		System.out.println("재료 갯수 : "+k.length);
		
		for(int i=0; i<ingredList.size() ; i++) {
			service.createIngred(ingredList.get(i));
//			System.out.println(ingredList.get(i).getIngred() +" "+ingredList.get(i).getIngred_code() );
			
		}
	}
	
	@RequestMapping(value="/food", method=RequestMethod.GET)
	public void insertFoodGET() throws Exception {
		logger.info("insertFoodGET get ...");
	}
	
	@RequestMapping(value="/food", method=RequestMethod.POST)
	public void insertFoodPOST(@ModelAttribute("food") String str) throws Exception {
		logger.info("insertFoodPOST POST ...");
		
		FoodVO in = null;
		List<FoodVO> foodList = new ArrayList<FoodVO>();
		String[] k = str.split("\n");
		for(int i=0 ;i<k.length ; i++) {
			String[] k2 = k[i].split("\t");
			in = new FoodVO();
			in.setFname(k2[0]);
			in.setFcode(k2[1]);
			in.setIngredset(k2[2]);
			foodList.add(in);
			in=null;	

		}
		System.out.println("음식 갯수 : "+k.length);
		
		for(int i=0; i<foodList.size() ; i++) {
			service.create(foodList.get(i));
//			System.out.println(foodList.get(i).getFcode() +" "+foodList.get(i).getFname() + foodList.get(i).getIngredset());
			
		}
	}
	
	@RequestMapping(value="/morp", method=RequestMethod.GET)
	public void insertMorpGET() throws Exception {
		logger.info("insertMorpGET get ...");
	}
	
	@RequestMapping(value="/morp", method=RequestMethod.POST)
	public void insertMorpPOST(@ModelAttribute("morp") String str) throws Exception {
		logger.info("insertMorpPOST POST ...");
		
		MorpVO in = null;
		List<MorpVO> morpList = new ArrayList<MorpVO>();
		String[] k = str.split("\n");
		for(int i=0 ;i<k.length ; i++) {
			String[] k2 = k[i].split("\t");
			in = new MorpVO();
			in.setMorp(k2[0]);
			in.setMorp_code(k2[1]);
			morpList.add(in);
			in=null;	

		}
		System.out.println("형용사 갯수 : "+k.length);
		
		for(int i=0; i<morpList.size() ; i++) {
			service.createMorp(morpList.get(i));
//			System.out.println(foodList.get(i).getFcode() +" "+foodList.get(i).getFname() + foodList.get(i).getIngredset());
			
		}
	}
	
	@RequestMapping(value="/taste", method=RequestMethod.GET)
	public void insertTasteGET() throws Exception {
		logger.info("insertTasteGET get ...");
	}
	
	@RequestMapping(value="/taste", method=RequestMethod.POST)
	public void insertTastePOST(@ModelAttribute("taste") String str) throws Exception {
		logger.info("insertTastePOST POST ...");
		
		TasteVO in = null;
		List<TasteVO> tasteList = new ArrayList<TasteVO>();
		String[] k = str.split("\n");
		for(int i=0 ;i<k.length ; i++) {
			String[] k2 = k[i].split("\t");
			in = new TasteVO();
			in.setTaste(k2[0]);
			in.setTaste_code(k2[1]);
			tasteList.add(in);
			in=null;	

		}
		System.out.println("맛 갯수 : "+k.length);
		
		for(int i=0; i<tasteList.size() ; i++) {
			service.createTaste(tasteList.get(i));
//			System.out.println(foodList.get(i).getFcode() +" "+foodList.get(i).getFname() + foodList.get(i).getIngredset());
			
		}
	}
	
	@RequestMapping(value="/train", method=RequestMethod.GET)
	public void insertTrainGET() throws Exception {
		logger.info("insertTrainGET get ...");
	}
	
	@RequestMapping(value="/train", method=RequestMethod.POST)
	public void insertTrainPOST(@ModelAttribute("train") String str) throws Exception {
		logger.info("insertTrainPOST POST ...");
		
		InitTrain it = new InitTrain(service);
		
	
	}
}
