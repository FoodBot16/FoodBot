package org.foodbot.mlp;

import java.util.ArrayList;
import java.util.List;

import org.foodbot.domain.FoodVO;
import org.foodbot.nlp.Recipe;

public class InitRecipe implements Recipe {

	// 레시피의 재료가 다르기때문에 이중리스트를 만듬 
	private List<ArrayList<String>> recipeList;
	private List<String> RAttrList;

	private List<FoodVO> recipeAll;

	public InitRecipe(List<FoodVO> recipeAll) throws Exception {
		this.recipeAll = recipeAll;



		recipeList = new ArrayList<ArrayList<String>>();

		setRAttrList(recipeAll);


	}

	@Override
	public List<String> getRecipe() throws Exception {
		return RAttrList;
	}

	@Override
	public void setRAttrList(List<FoodVO> flist) throws Exception {
		String[] ingredStr= {""};
		String[] tasteStr={""};
		for(int i=0 ;i<flist.size() ; i++) {
			if(ingredStr != null) ingredStr=null;
			if(tasteStr != null) tasteStr=null;

			if(flist.get(i).getIngredset() != null) {
				ingredStr = flist.get(i).getIngredset().split(",");
			}
			if(flist.get(i).getTasteset() != null) {
				tasteStr = flist.get(i).getTasteset().split(",");
			}

			// 각 리스트별로 레시피 리스트를 넣는다.
			RAttrList = new ArrayList<String>();
			recipeList.add((ArrayList<String>) inputRAttr(ingredStr, tasteStr));
		}
	}

	private List<String> inputRAttr(String[] ingredStr, String[] tasteStr) {
		if(ingredStr != null) {
			for(int i=0 ; i<ingredStr.length ; i++) {
				if(!ingredStr[i].trim().equals("") && !ingredStr[i].trim().equals(null))
					RAttrList.add(ingredStr[i]);
			}
		}
		if(tasteStr != null) {
			for(int i=0 ; i<tasteStr.length ; i++) {
				if(!tasteStr[i].trim().equals("") && !tasteStr[i].trim().equals(null))
					RAttrList.add(tasteStr[i]);
			}
		}
//		System.out.println("--------------RAttrList-RAttrList");
//		for(int i=0 ; i<RAttrList.size() ;i++) {
//			System.out.print(RAttrList.get(i)+ "  " );
//		}
		return RAttrList;
	}

	public List<ArrayList<String>> getRecipeList() {
		return recipeList;
	}

	public void setRecipeList(List<ArrayList<String>> recipeList) {
		this.recipeList = recipeList;
	}

}
