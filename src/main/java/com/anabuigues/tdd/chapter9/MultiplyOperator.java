package com.anabuigues.tdd.chapter9;

public class MultiplyOperator extends MathOperator {

	public MultiplyOperator() {
		super(2);
		token = "*";
	}

	@Override
	public int resolve(int a, int b) {
		return calcProxy.binaryOperation(OperationType.multiply, a, b);
	}
}
