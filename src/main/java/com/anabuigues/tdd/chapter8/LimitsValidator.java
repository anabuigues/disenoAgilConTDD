package com.anabuigues.tdd.chapter8;

public interface LimitsValidator {

	void setLimits(int a, int b);

	void validateArgs(int a, int b);

	void validateResult(int a);
}
