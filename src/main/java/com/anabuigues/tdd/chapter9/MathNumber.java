package com.anabuigues.tdd.chapter9;

public class MathNumber extends MathToken {

	public MathNumber() {
		super(0);
	}

	public MathNumber(String token) {
		super(token);
	}

	public int intValue(String token) {
		return Integer.parseInt(token);
	}

	@Override
	public int resolve() {
		return intValue(token);
	}
}
