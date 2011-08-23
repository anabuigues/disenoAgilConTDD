package com.anabuigues.tdd.chapter9;

public class Calculator implements BasicCalculator {

	@Override
	public int add(int arg1, int arg2) {
		return arg1 + arg2;
	}

	@Override
	public int substract(int arg1, int arg2) {
		return arg1 - arg2;
	}

	@Override
	public int multiply(int arg1, int arg2) {
		return arg1 * arg2;
	}

	@Override
	public int divide(int arg1, int arg2) {
		return arg1 / arg2;
	}
}
