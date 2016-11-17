package org.foodbot.mlp;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.foodbot.domain.FoodVO;
import org.foodbot.service.FoodService;

/*
 * Management authority
 * get InitTrainData for init train
 */
public class InitTrainData {

	@Inject 
	private FoodService fservice;

	private Double[] input_value;
	private List<Double> input;

	private List<FoodVO> recipeAll;
	private List<String> dataName;
	private List<String> foodName;

	// db의 모든 레시피 리스트
	private List<ArrayList<String>> recipeList;
	
	// 최종 분류기 입력값
	private List<ArrayList<Double>> trainDataList;
	private List<Double> tempList;

	public InitTrainData(FoodService fservice) throws Exception {
		this.fservice = fservice;

		trainDataList = new ArrayList<ArrayList<Double>>();
		recipeAll = fservice.readRecipeAll();

		// input 갯수 만큼의 배열크기로 만듬
		input_value = new Double[HyperParameter.INPUT_NUM];
		// input 초기값을 불러옴
		input = HyperParameter.input;

		
		// 모든 레시피를 불러옴
		InitRecipe ir = new InitRecipe(recipeAll);
		recipeList = ir.getRecipeList();

		// 분류기 입력노드 (속성) 불러옴
		TrainData trainData = new TrainData(fservice);
		dataName = trainData.getDataName();
		foodName = trainData.getOutputName();
		
		System.out.println("recipeList  " +recipeList.size() +" " + recipeList.get(0).size() + " " + recipeList.get(0).get(0));
		System.out.println("dataName " + dataName.size() );
		System.out.println("foodName " + foodName.size() );
		
		// 분류기 입력노드 순서 출력
//		for(int i= 0 ; i<dataName.size() ; i++) {
//			System.out.print(i+dataName.get(i) + "    ");
//		}System.out.println();
		
		// 모든 레시피 출력
//		for(int i=0 ; i<recipeList.size() ;i++) {
//			for(int j=0 ; j<recipeList.get(i).size() ; j++) {
//				System.out.print(recipeList.get(i).get(j) + "   ");
//			}System.out.println();
//		}System.out.println();

		boolean flag = false;
		for(int i=0 ; i<recipeList.size() ; i++) {
			tempList = new ArrayList<Double>();
			for(int j=0 ; j<dataName.size(); j++) {
				for(int k=0 ; k<recipeList.get(i).size() ; k++) {
					if(dataName.get(j).equals(recipeList.get(i).get(k))) {
						tempList.add(HyperParameter.INIT_NOMAL_VALUE);
						flag = false;
						break;
					} else {
						flag = true;
					}
				}
				if(flag == true) {
					tempList.add(HyperParameter.INIT_INPUT_VALUE);
					flag = false;
				}
			}
			trainDataList.add((ArrayList<Double>) tempList);
			tempList = null;
		}

		// 분류기에 입력할 최종값 위치 출력
//		for(int i=0 ; i<trainDataList.size(); i++) {
//			System.out.print(i + " : " + trainDataList.get(i).size() + " : ");
//			for(int j=0 ; j<trainDataList.get(i).size() ; j++) {
//				if(trainDataList.get(i).get(j) != 0.0) {
//					System.out.print(j + "   ");
//				}
//			}
//			System.out.println();
//		}

	}

	public List<ArrayList<Double>> getTrainDataList() {
		return trainDataList;
	}

	public void setTrainDataList(List<ArrayList<Double>> trainDataList) {
		this.trainDataList = trainDataList;
	}
	
}
