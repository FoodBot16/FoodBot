package org.foodbot.mlp;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.awt.Panel;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.foodbot.service.FoodService;

public class InitTrain {
	
	private MLPFunction mlpFunc;
	@Inject 
	private FoodService fservice;

	// each layer's activation
	private List<double[][]> activationList = new ArrayList<double[][]>();
	// each laery's z function
	private List<double[][]> beforeActivationList = new ArrayList<double[][]>();
	// each layer's error
	private List<double[][]> deltaList = new ArrayList<double[][]>();
	// each layer's gradientdecent 
	private List<double[][]> gradientDecentList = new ArrayList<double[][]>();
	// bias
	private List<double[]> biasList = new ArrayList<double[]>();
	// training input data List
	private List<ArrayList<Double>> trainDataList;
	public static double[][] trainInputData;
	public static double[][] batchInputData;
	// training output data List
	public static double[] trainOutput;

	// random batch list
	private static int[] pattern;
	private static int[] batchNum;
	// training set num
	private static int patternNum;

	public static double errThisPat;
	public static double outPred;	
	public static double RMSerror;

	//	public static double[] hiddenVal = new double[HyperParameter.HIDDEN_NUM];


	public static double LR_IH = 0.7; // Input-Hidden learning rate
	public static double LR_HO = 0.07; // Hidden-Output learning rate

	public InitTrain(FoodService fservice) throws Exception {
		this.fservice = fservice;

		// mlp function instance ..
		mlpFunc = new MLPFunction();

		// input data
		InitTrainData itd = new InitTrainData(fservice);
		trainDataList = itd.getTrainDataList();

		patternNum = trainDataList.size();
		batchNum = new int[HyperParameter.BATCH_NUM];
		pattern = new int[patternNum];
		trainInputData = new double[patternNum][HyperParameter.INPUT_NUM];
		batchInputData = null;
		trainOutput = new double[patternNum];


		initWeights();
		initBias();

		/*
		 * 입력 패턴 y를 순서(0~갯수) 대로 설정..
		 * y 클래스 번호를 입력하기 위한 클래스를 따로 설정해 줘야하지만
		 * 일단 레시피 갯수만큼 학습하기때문에 임시로 설정..
		 */
		for(int i=0 ;i<patternNum; i++) {
			trainOutput[i] = i;
		}
		for(int i=0  ; i<patternNum ; i++) {
			for(int j=0 ; j<trainDataList.get(i).size() ; j++) {
				trainInputData[i][j] = trainDataList.get(i).get(j);
			}
		}
		//		trainInputData = addBiasToActivation(trainInputData,0);
		System.out.println("trainInputDatatrainInputData" +trainInputData.length + " "+trainInputData[0].length);
		// init weight
		for(int i=0 ; i<trainInputData.length ; i++) {
			System.out.print(i+" ");
			for(int j=0 ; j<trainInputData[i].length ; j++) {
				System.out.print(trainInputData[i][j] + " ");
			}
			System.out.println();
		}

		for (int j = 0; j <= HyperParameter.EPOCH; j++) {
			setBatch();
			calcNet();
			//			calcOverallError();
			System.out.println("epoch = " + j + "  RMS Error = " + RMSerror);
			System.out.println(j + "th cost is "+cost());
		}

		displayResults();

	}
	public void displayResults() {
		setBatchData(pattern);
		beforeActivationList = feedForwardCalc(pattern);
		activationList = makeActivate(beforeActivationList);
		double[][] result = activationList.get(activationList.size()-1);
		System.out.println("***********************************");
		for (int i = 0; i < patternNum; i++) {
			System.out.println(i+ "번째 데이터  " );
			for(int j=0 ; j<result[i].length ; j++) {
				System.out.printf("%.2f  ",result[i][j]);
//				System.out.print(result[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println("***********************************");
	}

	public void calcNet() {
		beforeActivationList = feedForwardCalc(batchNum);
		activationList = makeActivate(beforeActivationList);
		deltaList = bpCalc();
		gradientDecentList = gradientDecent(deltaList);
		for(int i=0 ; i<HyperParameter.weights.size() ; i++) {
			//			System.out.println(i + " 번째 wieght "
			//						+ HyperParameter.weights.get(i).length + " " +HyperParameter.weights.get(i)[0].length 
			//						+ " " + HyperParameter.weights.get(i)[0][0]);
			for(int j=0 ; j<HyperParameter.weights.get(i).length ; j++) {
				//				System.out.println(j+ " 번째 레이어");
				for(int k=0 ; k<HyperParameter.weights.get(i)[j].length ; k++) {
					//					System.out.print(HyperParameter.weights.get(i)[j][k] + " ");
				}
				//				System.out.println();
			}
			System.out.println();
		}
		for(int i=0 ; i<activationList.size() ;i++) {
			System.out.println("beforeActivationList "+" "+beforeActivationList.get(i).length + " "+beforeActivationList.get(i)[0].length);
		}
		for(int i=0 ; i<activationList.size() ;i++) {
			System.out.println("activationList "+" "+activationList.get(i).length + " "+activationList.get(i)[0].length);
		}
		for(int i=0 ; i<deltaList.size() ;i++) {
			System.out.println("deltaList "+" "+deltaList.get(i).length + " "+deltaList.get(i)[0].length);
		}
		for(int i=0 ; i<gradientDecentList.size() ;i++) {
			System.out.println("gradientDecentList "+" "+gradientDecentList.get(i).length + " "+gradientDecentList.get(i)[0].length);
		}
		//		for(int i =0 ;i<gradientDecentList.size() ; i++) {
		//			System.out.println("gradientDecentList.size() "+gradientDecentList.size()+" "+ gradientDecentList.get(i).length +
		//									 "  " + gradientDecentList.get(i)[0].length);
		//			
		//				
		//		}
		learning();
		//		saveBias();
	}
	private void initBias() {
		for(int j=0; j<patternNum ; j++) {
			for(int k=0 ; k<HyperParameter.TOTAL_LAYER_NUM ; k++) {
				HyperParameter.biasList.get(k)[j] = 1;
			}
		}
	}

	private void saveBias() {
		for(int i=0 ; i<patternNum ; i++) {
			for(int j=0; j<batchNum.length ; j++) {
				if(batchNum[j] == i) {
					for(int k=0 ; k<activationList.size() ; k++) {
						HyperParameter.biasList.get(k)[batchNum[j]] = activationList.get(k)[j][0];
						System.out.println(k+"레이어 "+batchNum[j]+"번째 set  activationList.get(k)[j][0] " +activationList.get(k)[j][0]);
					}
				}
			}
		}
	}

	private void learning() {
		for(int i=0 ; i<HyperParameter.weights.size() ; i++) {
			for(int j=0 ; j<HyperParameter.weights.get(i).length ; j++) {
				for(int k=0 ; k<HyperParameter.weights.get(i)[j].length ; k++) {
					HyperParameter.weights.get(i)[j][k] 
							= HyperParameter.weights.get(i)[j][k] 
									- (HyperParameter.LEARNING_RATE * gradientDecentList.get(HyperParameter.weights.size()-i-1)[j][k]);
				}
			}
		}
	}

	private List<double[][]> bpCalc() {
		List<double[][]> tmpDeltaList = new ArrayList<double[][]>();
		double[][] tmpDelta;
		for(int i=HyperParameter.BP_NUM-1 ; i>=0; i--) {
			switch(i) {
			// output layer's delta (error)
			case HyperParameter.BP_NUM-1 :
				double[][] lastAct = activationList.get(activationList.size()-1);
				tmpDelta = lastAct;
				//				System.out.println("lastAct data size " + lastAct.length);
				// batch set
				for(int j=0 ; j<batchNum.length ; j++) {
					// each training set의 output label과 
					// 모든 output label 을 비교하여 맞는 index의 activation 값만 -1을 취한다.
					for(int k = 0; k<HyperParameter.OUTPUT_NUM; k++) {
						if(batchNum[j] == k) {
							tmpDelta[j][k] = lastAct[j][k]-1;
						}
					}
				}
				tmpDeltaList.add(tmpDelta);
				//				System.out.println("deltaList 1 : " +tmpDeltaList.get(0).length);
				//				System.out.println("weight size "+HyperParameter.weights.size());
				break;
				// hidden layer's delta (error)
			default :
				double[][] beforeAct = beforeActivationList.get(i+1);
				tmpDelta = new double[beforeAct.length][beforeAct[0].length];
				// batch
				for(int j=0 ; j<batchNum.length ; j++) {
					double[][] tmpWeight = HyperParameter.weights.get(i+1);
					// weight 입력단
					for(int n=0; n<tmpWeight.length ; n++) {
						// weight 출력단
						for(int m=0 ; m<tmpWeight[n].length ; m++) {
							//System.out.println(j + " " + " " + m + " " + n + " " + tmpWeight[n].length);
							tmpDelta[j][m] = tmpWeight[n][m] * tmpDeltaList.get(tmpDeltaList.size()-1)[j][m] * mlpFunc.ReLUGradient(beforeAct[j][m]);
						}
					}
				}
				tmpDeltaList.add(tmpDelta);
				//				System.out.println("tmpDelta " + tmpDelta.length);
				//				delta_2 = Theta2' * delta_3' .* sigmoidGradient([1, z2(t, :)])';
				//						delta_2 = delta_2(2:end);
				break;
			}
		}
		for(int i=0 ; i<tmpDeltaList.size() ; i++) {
			//			System.out.println("deltaList "+ i + " " + tmpDeltaList.get(i).length + " " + tmpDeltaList.get(i)[0].length);
		}
		return tmpDeltaList;
	}

	private List<double[][]> gradientDecent(List<double[][]> delta) {
		List<double[][]> tmpList = new ArrayList<double[][]>();
		List<double[][]> tmpGradientList = new ArrayList<double[][]>();
		double[][] tmpGradient = null;
		double[][] tmp = null;
		for(int d=0 ; d<delta.size() ; d++) {
			if(d != 0)
				tmp = new double[delta.get(d).length][delta.get(d)[0].length-1];
			else 
				tmp = new double[delta.get(d).length][delta.get(d)[0].length];
			for(int i=0 ; i<tmp.length ; i++) {
				for(int j=0 ;j<tmp[i].length ; j++) {
					if(d != 0)
						tmp[i][j] = delta.get(d)[i][j+1];
					else 
						tmp[i][j] = delta.get(d)[i][j];
				}
			}
			tmpList.add(tmp);
		}
		for(int i=0 ; i<tmpList.size() ; i++) {	
			tmpGradient = new double[activationList.get(tmpList.size()-i-1)[0].length][tmpList.get(i)[0].length];
			for(int j=0 ; j<tmpList.get(i).length ; j++) {
				for(int l=0 ; l<activationList.get(tmpList.size()-i-1)[j].length ; l++) {
					for(int k=0 ; k<tmpList.get(i)[j].length ; k++) {
						tmpGradient[l][k] =  activationList.get(tmpList.size()-i-1)[j][l] * tmpList.get(i)[j][k];
					}
				}
			}
			tmpGradientList.add(tmpGradient);
		}
		return tmpGradientList;
	}

	// trainset을 batch_num 만큼 랜덤set 으로 가져온다.
	private void setBatch() {
		int tmp = -1;
		boolean flag = false;
		for(int i=0 ;i<batchNum.length ; i++) {
			tmp = (int) ((Math.random() * patternNum) - 0.001);
			for(int j=0; j <= i; j++) {
				if(tmp==batchNum[j]) {
					flag = false;
					break;
				} else {
					flag = true;
				}
			}
			if(flag == true) 
				batchNum[i] = tmp;
		}
		for(int i=0 ; i<pattern.length ; i++) {
			pattern[i] = i;
		}
		setBatchData(batchNum);
	}

	private void setBatchData(int[] batch) {
		batchInputData = new double[batch.length][HyperParameter.INPUT_NUM];
		for(int i=0 ; i<batch.length ; i++) {
			batchInputData[i] = trainInputData[batch[i]];
		}
	}
	/*
	 *  2~output layer 까지의 activation List 를 구한다.
	 */
	private List<double[][]> feedForwardCalc(int[] dataSet) {
		List<double[][]> actList = new ArrayList<double[][]>();
		// a1 insert ( input data )
		actList.add(addBiasToActivation(batchInputData,0));

		// feed forward calc
		// activation : sigmoid
		for(int i=0 ; i<HyperParameter.weights.size() ; i++) {
			double[][] tmp =  new double[dataSet.length][HyperParameter.weights.get(i)[0].length];
			// hidden node 의 activation 함수에 bias 를 추가한다.
			if(i<HyperParameter.weights.size()-1)
				tmp = addBiasToActivation(tmp,i+1);
			for(int n=0; n<dataSet.length ; n++) {
				for(int j=0 ;j<HyperParameter.weights.get(i)[0].length; j++) {
					for(int k=0 ; k<HyperParameter.weights.get(i).length; k++) {
//						System.out.println("n "+n + " k " +k+" i " + i );
						tmp[n][j] = tmp[n][j]  + actList.get(i)[n][k] * HyperParameter.weights.get(i)[k][j];
					}
				}
			}
			actList.add(tmp);
		}
		//		System.out.println("all activation size " + actList.size());
		return actList;
	}

	private List<double[][]> makeActivate(List<double[][]> tmp) {
		// input layer를 제외한 모든 layer activate
		for(int i=1 ; i<tmp.size() ; i++) {
			for(int j=0; j<tmp.get(i).length ; j++){
				for(int k=0 ; k<tmp.get(i)[j].length ; k++) {
					tmp.get(i)[j][k] = mlpFunc.ReLU(tmp.get(i)[j][k]);
				}
			}
		}
		return tmp;
	}

	// 최초 feedfoward에 hidden node's activation에 bias를 추가한다.
	// 두번째부턴 생각을 ..
	private double[][] addBiasToActivation(double[][] act, int layer) {
		double[][] tmp = new double[act.length][act[0].length+1];

		for(int i=0; i<act.length ; i++) {
			for(int j=0 ; j<act[i].length ; j++) {
				if(j==0) {
					tmp[i][0] = HyperParameter.biasList.get(layer)[i];
				}
				else
					tmp[i][j+1] = act[i][j];
			}
		}
		return tmp;
	}

	// cost는 전체 dataset 에 대한 정보이다.
	public double cost() {
		setBatchData(pattern);
		List<double[][]> actList = makeActivate(feedForwardCalc(pattern));
		double[][] hypo = actList.get(actList.size()-1);

		// cost
		double J = 0.0;
		/*
		 * cost operation
		 */
		for(int i=0 ;i<HyperParameter.OUTPUT_NUM ; i++) {
			double htheta[] = new double[HyperParameter.OUTPUT_NUM];
			double yi[] = new double[patternNum];
			double jk = 0.0;
			/*
			 * 클래스 label과 dataset label
			 * 값이 같으면 1 다르면 0으로 된  벡터를 생성한다
			 */
			for(int j=0 ;j<patternNum ; j++) { 
				if(i==j)
					yi[j] = 1;
				else 
					yi[j] = 0;
			}
//			for(int j=0 ; j<patternNum ; j++) {
//				System.out.print(yi[j] + " ");
//			}System.out.println();

			/*
			 * 현재 연산중인 class에 대한 attribute value 를 가져온다
			 */
			for(int k=0 ; k<hypo[i].length ; k++) {
				htheta[k] = hypo[i][k];
				//				System.out.println("htheta"+htheta[k] );
			}
			/*
			 * 각 class 별로 cost를 구한 후 모두 더한다
			 */
			jk = (1.0/patternNum)*sum(yi,htheta);
			J = J + jk;

		}
		return J;
	}

	private double sum(double[] yi, double[] htheta) {
		double sum=0.0;
		for(int i=0 ; i<yi.length; i++) {	
//						System.out.println("yi " + yi[i]);
			for(int j=0 ; j<htheta.length ; j++) {
//				System.out.println("1    "+htheta[j] );
//				System.out.println("2    "+(double)Math.log(htheta[j]));
				sum += ((-yi[i] * (double)Math.log(htheta[j])) - ((1.0-yi[i]) * (double)Math.log(1.0-htheta[j])));
			}
		}
		return sum;
	}

	// weight's init value setting 
	public static void initWeights() {
		for(int i=0 ; i<HyperParameter.weights.size() ; i++) {
			for(int j=0 ; j<HyperParameter.weights.get(i).length ; j++) {
				for(int k=0 ; k<HyperParameter.weights.get(i)[j].length ; k++) {
					HyperParameter.weights.get(i)[j][k] = (Math.random() - 0.5) / 10;
				}
			}
			//			System.out.println("weight size " + i+" "+HyperParameter.weights.get(i).length +" "+HyperParameter.weights.get(i)[0].length);
		}
	}



	/*
	// ************************************
	public static void WeightChangesHO()	{
		for (int k = 0; k < HyperParameter.HIDDEN_NUM; k++) {
			double weightChange = LR_HO * errThisPat * hiddenVal[k];
			HyperParameter.weightsHO[k] = HyperParameter.weightsHO[k] - weightChange;

			// ����������� ����ġ ����ȭ(regularization on the output weights)
			if (HyperParameter.weightsHO[k] < -5)
				HyperParameter.weightsHO[k] = -5;
			else if (HyperParameter.weightsHO[k] > 5)
				HyperParameter.weightsHO[k] = 5;
		}
	}

	// ************************************
	public static void WeightChangesIH()	{
		// Input-Hidden ����ġ ����(adjust the weights input-hidden)
		for (int i = 0; i < HyperParameter.HIDDEN_NUM; i++) {
			for (int k = 0; k < HyperParameter.INPUT_NUM; k++) {
				double x = 1 - (hiddenVal[i] * hiddenVal[i]);
				x = x * HyperParameter.weightsHO[i] * errThisPat * LR_IH;
				x = x * trainInputData[patNum][k];
				double weightChange = x;
				HyperParameter.weightsIH[k][i] = HyperParameter.weightsIH[k][i] - weightChange;
			}
		}
	}


	 */
}
