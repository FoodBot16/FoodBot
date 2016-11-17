package org.foodbot.mlp;

public interface ActivationFunction {
	public double sigmoid(double x);
	public double tanh(double x);
	public double ReLU(double x);
	
}
