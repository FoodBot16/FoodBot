package org.foodbot.nlp;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.foodbot.domain.FoodVO;
import org.foodbot.service.FoodService;

/*
 * 
 * 채팅 입력에 대한 최종적인 모든 속성값을 가진
 */
public class PersonalRecipe implements Recipe {

	@Inject
	FoodService fservice;
	
	private List<String> RAttrList;
	private List<FoodVO> flist;
	
	private MorpProcess mp;
	
	public PersonalRecipe() {}
	public PersonalRecipe(FoodService fservice,MorpProcess mp) {
		this.fservice = fservice;
		this.mp = mp;
		RAttrList = new ArrayList<String>();
		
	}
	
	@Override
	public List<String> getRecipe() {
		return RAttrList;
	}
	public void setRAttrRecipe() throws Exception {
		for(int i=0 ; i<mp.getWordList().size() ; i++) {
			System.out.println(mp.getWordList().get(i));
		}
		for(int i=0 ; i<mp.getWordList().size() ; i++) {
			flist = fservice.readRecipe(mp.getWordList().get(i));
			setRAttrList(flist);
		}
	}
	
	// 재료/맛의 각각 구분자를 나누어 각각 배열에 넣는다.
	@Override
	public void setRAttrList(List<FoodVO> flist) throws Exception {
		String[] ingredStr= {""};
		String[] tasteStr={""};
		for(int i=0 ;i<flist.size() ; i++) {
			if(flist.get(i).getIngredset() != null) {
				ingredStr = flist.get(i).getIngredset().split(",");
			}
			if(flist.get(i).getTasteset() != null) {
				tasteStr = flist.get(i).getTasteset().split(",");
			}
			inputRAttr(ingredStr, tasteStr);
		}
	}
	
	private void inputRAttr(String[] ingredStr, String[] tasteStr) {
		for(int i=0 ; i<ingredStr.length ; i++) {
			if(!ingredStr[i].trim().equals("") && !ingredStr[i].trim().equals(null))
				RAttrList.add(ingredStr[i]);
		}
		for(int i=0 ; i<tasteStr.length ; i++) {
			if(!tasteStr[i].trim().equals("") && !tasteStr[i].trim().equals(null))
				RAttrList.add(tasteStr[i]);
		}
	}
}
