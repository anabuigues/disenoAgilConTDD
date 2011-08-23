package com.anabuigues.tdd.chapter9;

public class SubstractOperator extends MathOperator {

	public SubstractOperator() {
		super(1);
		token = "-";
	}

	@Override
	public int resolve(int a, int b) {
		return calcProxy.binaryOperation(OperationType.substract, a, b);
	}
}
