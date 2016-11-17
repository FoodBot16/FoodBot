package org.foodbot.mlp;

import java.util.ArrayList;
import java.util.List;

import org.foodbot.service.FoodService;
import org.springframework.stereotype.Service;

@Service
public class HyperParameter {

	public static final int INPUT_NUM = 142;
	public static final int OUTPUT_NUM = 64; // 1~클래스 갯수
	public static final double INIT_INPUT_VALUE = 0.0;
	public static final double INIT_NOMAL_VALUE = 1.0;

	public static final int HIDDEN_LAYER_NUM = 3;
	public static final int[] HIDDEN_NUM = {284,284,284};
	
	public static final int WEIGHT_NUM = HIDDEN_LAYER_NUM + 1;
	public static final int TOTAL_LAYER_NUM = WEIGHT_NUM +1;
	// backpropagation layer num
	public static final int BP_NUM = WEIGHT_NUM;
	

	public static final int EPOCH = 5000;
	public static final int BATCH_NUM= 20;
	
	public static final int BIAS_NUM = 1;
	
	public static final double LEARNING_RATE = 0.03;

	public static List<Double> input;
	public static List<double[]> biasList = new ArrayList<double[]>();
	
	// weight는 bias를 고려하여 넣는다.
	public static List<double[][]> weights = new ArrayList<double[][]>();

	public HyperParameter() throws Exception {
		//weight init setting
		// 원래 W_ij 는 입력(j) 출력(i) 이지만 편의를 위해 반대로 했음 
		if(HIDDEN_LAYER_NUM > 0) {
			int h=0;
			for(int i=0 ; i<WEIGHT_NUM ; i++) {
				if(i == 0) {
					// input to hidden weight setting
					weights.add(new double[INPUT_NUM+BIAS_NUM][HIDDEN_NUM[h]]);
					h++;
				} else if(i == WEIGHT_NUM-1) {
					// hidden to output weight setting
					weights.add(new double[HIDDEN_NUM[HIDDEN_NUM.length-1]+BIAS_NUM][OUTPUT_NUM]);
				} else {
					// hidden to hidden weight setting
					weights.add(new double[HIDDEN_NUM[h-1]+BIAS_NUM][HIDDEN_NUM[h]]);
					h++;
				}
			}
		} 
		else {
			// input to output weight setting
			weights.add(new double[INPUT_NUM+BIAS_NUM][OUTPUT_NUM]);
		}
		
		// 총 데이터 set 당  layer 갯수만큼의 bias가 생성됨
		for(int i=0 ; i<TOTAL_LAYER_NUM ; i++) {
			biasList.add(new double[OUTPUT_NUM]);	
		}
		
//		
		input = new ArrayList<Double>();
		for(int i=0 ; i<INPUT_NUM ; i++) {
			input.add(INIT_INPUT_VALUE);
		}
	}
}