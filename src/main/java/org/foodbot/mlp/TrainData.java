package org.foodbot.mlp;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.foodbot.domain.FoodVO;
import org.foodbot.domain.IngredVO;
import org.foodbot.domain.TasteVO;
import org.foodbot.service.FoodService;

public class TrainData {

	private List<String> dataName;
	private List<String> dataCode;

	private List<String> outputName;
	private List<String> outputCode;

	@Inject 
	private FoodService fservice;
	public TrainData(FoodService fservice) throws Exception {
		this.fservice = fservice;

		dataName = new ArrayList<String>();
		dataCode = new ArrayList<String>();

		outputName = new ArrayList<String>();
		outputCode = new ArrayList<String>();

		setData();

	}

	// data set for neural network train
	private void setData() throws Exception {
		List<IngredVO> ingredList = fservice.readIngredAll();
		List<TasteVO> tasteList = 	fservice.readTasteAll();
		List<FoodVO> foodList = 	fservice.readFoodAll();

		for(int i=0 ;i<foodList.size() ; i++) {
			outputName.add(foodList.get(i).getFname());
			outputCode.add(foodList.get(i).getFcode());
		}
		for(int i=0 ; i<ingredList.size() ; i++) {
			dataName.add(ingredList.get(i).getIngred());
			dataCode.add(ingredList.get(i).getIngred_code());
		}
		for(int i=0 ; i<tasteList.size() ; i++) {
			dataName.add(tasteList.get(i).getTaste());
			dataCode.add(tasteList.get(i).getTaste_code());
		}

		//		for(int i=0; i<dataName.size() ; i++) {
		//			System.out.println(dataName.get(i));
		//		}System.out.println(dataName.size());
	}

	public List<String> getDataName() {
		return dataName;
	}

	public void setDataName(List<String> dataName) {
		this.dataName = dataName;
	}

	public List<String> getDataCode() {
		return dataCode;
	}

	public void setDataCode(List<String> dataCode) {
		this.dataCode = dataCode;
	}

	public List<String> getOutputName() {
		return outputName;
	}

	public void setOutputName(List<String> outputName) {
		this.outputName = outputName;
	}

	public List<String> getOutputCode() {
		return outputCode;
	}

	public void setOutputCode(List<String> outputCode) {
		this.outputCode = outputCode;
	}

}
