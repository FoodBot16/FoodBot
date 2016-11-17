package org.foodbot.nlp;

import java.util.List;

import org.foodbot.domain.FoodVO;

public interface Recipe {

	 List<String> getRecipe() throws Exception;
	 void setRAttrList(List<FoodVO> flist) throws Exception;
}
