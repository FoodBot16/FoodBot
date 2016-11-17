package org.foodbot.mlp;

public class MLPFunction implements ActivationFunction,GradientFunction{

	@Override
	public double sigmoid(double x) {
		return 1/(1+Math.exp(-x));
	}

	@Override
	public double sigmoidGradient(double x) {
		return sigmoid(x) * (1 - sigmoid(x));
	}

	@Override
	public double tanh(double x) {
		return Math.tanh(x);
//		if (x > 20)
//			return 1.0;
//		else if (x < -20)
//			return -1.0;
//		else {
//			double a = Math.exp(x);
//			double b = Math.exp(-x);
//			return (a - b) / (a + b);
//		}
	}

	@Override
	public double tanhGradient(double x) {
		return (1.0 - (tanh(x)*tanh(x)));
	}

	@Override
	public double ReLUGradient(double x) {
		if(x>=0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public double ReLU(double x) {
		if(x >= 0 ) {
			return x;
		} else {
			return 0;			
		}
	}

}
