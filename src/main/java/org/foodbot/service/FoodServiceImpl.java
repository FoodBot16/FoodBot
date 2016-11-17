package org.foodbot.service;

import java.util.List;

import javax.inject.Inject;

import org.foodbot.domain.FoodVO;
import org.foodbot.domain.IngredVO;
import org.foodbot.domain.MorpVO;
import org.foodbot.domain.TasteVO;
import org.foodbot.persistence.FoodDAO;
import org.springframework.stereotype.Service;


@Service
public class FoodServiceImpl implements FoodService {

	@Inject
	FoodDAO dao;
	
	@Override
	public void create(FoodVO vo) throws Exception {
		dao.create(vo);
	}

	@Override
	public List<FoodVO> readFname(String fname) throws Exception {
		return dao.readFname(fname);
	}

	@Override
	public List<FoodVO> readRecipe(String fname) throws Exception {
		return dao.readRecipe(fname);
	}

	@Override
	public void update(FoodVO vo) throws Exception {
		
	}

	@Override
	public void delete(String fcode) throws Exception {
		
	}

	@Override
	public List<FoodVO> listAll() throws Exception {
		return null;
	}

	
	@Override
	public FoodVO readNNGOne(String nng) throws Exception {
		return dao.readNNGOne(nng);
	}

	@Override
	public MorpVO readMorpOne(String morg) throws Exception {
		return dao.readMorpOne(morg);
	}

	@Override
	public IngredVO readIngredOne(String ingred) throws Exception {
		return dao.readIngredOne(ingred);
	}

	@Override
	public TasteVO readTasteOne(String taste) throws Exception {
		return dao.readTasteOne(taste);
	}
	
	@Override
	public void createIngred(IngredVO vo) throws Exception {
		dao.createIngred(vo);
	}

	@Override
	public void createTaste(TasteVO vo) throws Exception {
		dao.createTaste(vo);
	}

	@Override
	public void createMorp(MorpVO vo) throws Exception {
		dao.createMorp(vo);
	}

	@Override
	public List<IngredVO> readIngredAll() throws Exception {
		return dao.readIngredAll();
	}

	@Override
	public List<TasteVO> readTasteAll() throws Exception {
		return dao.readTasteAll();
	}

	@Override
	public List<FoodVO> readRecipeAll() throws Exception {
		return dao.readRecipeAll();
	}

	@Override
	public List<FoodVO> readFoodAll() throws Exception {
		return dao.readFoodAll();
	}




}
