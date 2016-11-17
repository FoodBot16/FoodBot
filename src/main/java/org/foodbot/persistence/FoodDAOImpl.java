package org.foodbot.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.foodbot.domain.FoodVO;
import org.foodbot.domain.IngredVO;
import org.foodbot.domain.MorpVO;
import org.foodbot.domain.TasteVO;
import org.springframework.stereotype.Repository;

@Repository
public class FoodDAOImpl implements FoodDAO {

	@Inject
	SqlSession session;
	
	private static String namespace = "org.foodbot.mapper.FoodMapper";
	
	@Override
	public void create(FoodVO vo) throws Exception {
		session.insert(namespace+".create",vo);
	}

	@Override
	public List<FoodVO> readFname(String fname) throws Exception {
		return session.selectList(namespace+".readFname",fname);
	}

	@Override
	public List<FoodVO> readRecipe(String fname) throws Exception {
		return session.selectList(namespace+".readRecipe",fname);
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
		return session.selectOne(namespace+".readNNGOne",nng);
	}

	@Override
	public MorpVO readMorpOne(String morg) throws Exception {
		return session.selectOne(namespace+".readMorpOne",morg);
	}

	@Override
	public IngredVO readIngredOne(String ingred) throws Exception {
		return session.selectOne(namespace+".readIngredOne",ingred);
	}
	@Override
	public TasteVO readTasteOne(String taste) throws Exception {
		return session.selectOne(namespace+".readTasteOne",taste);
	}



	@Override
	public void createIngred(IngredVO vo) throws Exception {
		session.insert(namespace+".createIngred",vo);
		
	}

	@Override
	public void createTaste(TasteVO vo) throws Exception {
		session.insert(namespace+".createTaste",vo);
	}

	@Override
	public void createMorp(MorpVO vo) throws Exception {
		session.insert(namespace+".createMorp",vo);
	}

	@Override
	public List<IngredVO> readIngredAll() throws Exception {
		return session.selectList(namespace+".readIngredAll");
	}

	@Override
	public List<TasteVO> readTasteAll() throws Exception {
		return session.selectList(namespace+".readTasteAll");
	}

	@Override
	public List<FoodVO> readRecipeAll() throws Exception {
		return session.selectList(namespace+".readRecipeAll");
	}

	@Override
	public List<FoodVO> readFoodAll() throws Exception {
		return session.selectList(namespace+".readFoodAll");
	}




	
}
