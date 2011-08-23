package com.anabuigues.tdd.chapter9;

public class DivideOperator extends MathOperator {

	public DivideOperator() {
		super(2);
		token = "/";
	}

	@Override
	public int resolve(int a, int b) {
		return calcProxy.binaryOperation(OperationType.divide, a, b);
	}
}
