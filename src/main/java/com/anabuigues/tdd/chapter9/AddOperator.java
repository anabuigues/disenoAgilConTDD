package com.anabuigues.tdd.chapter9;

public class AddOperator extends MathOperator {

	public AddOperator() {
		super(1);
		token = "+";
	}

	@Override
	public int resolve(int a, int b) {
		return calcProxy.binaryOperation(OperationType.add, a, b);
	}
}
