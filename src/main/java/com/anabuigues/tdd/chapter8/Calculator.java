package com.anabuigues.tdd.chapter8;

public class Calculator implements BasicCalculator {

	@Override
	public int add(int arg1, int arg2) {
		int result = arg1 + arg2;
		return result;
	}

	@Override
	public int substract(int arg1, int arg2) {
		int result = arg1 - arg2;
		return result;
	}
}
