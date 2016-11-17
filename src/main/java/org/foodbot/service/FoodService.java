package org.foodbot.service;

import java.util.List;

import org.foodbot.domain.FoodVO;
import org.foodbot.domain.IngredVO;
import org.foodbot.domain.MorpVO;
import org.foodbot.domain.TasteVO;

public interface FoodService {

	public void createIngred(IngredVO vo) throws Exception;
	public void createTaste(TasteVO vo) throws Exception;
	public void createMorp(MorpVO vo) throws Exception;
	
	public void create(FoodVO vo) throws Exception;
	public List<FoodVO> readFname(String fname) throws Exception;
	public List<FoodVO> readRecipe(String fname) throws Exception;
	public List<FoodVO> readRecipeAll() throws Exception;
	public void update(FoodVO vo) throws Exception;
	public void delete(String fcode) throws Exception;
	public List<FoodVO> listAll() throws Exception;
	
	public FoodVO readNNGOne(String nng) throws Exception;
	public MorpVO readMorpOne(String morg) throws Exception;
	public IngredVO readIngredOne(String ingred) throws Exception;
	public TasteVO readTasteOne(String taste) throws Exception;
	
	public List<IngredVO> readIngredAll() throws Exception;
	public List<TasteVO> readTasteAll() throws Exception;
	public List<FoodVO> readFoodAll() throws Exception;
}
