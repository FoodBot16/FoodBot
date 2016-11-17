package org.foodbot.mlp;

public interface GradientFunction {
	public double sigmoidGradient(double x);
	public double tanhGradient(double x);
	public double ReLUGradient(double x);
}
