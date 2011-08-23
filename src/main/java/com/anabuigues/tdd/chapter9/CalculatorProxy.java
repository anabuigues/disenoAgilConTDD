package com.anabuigues.tdd.chapter9;

public interface CalculatorProxy {

	int binaryOperation(OperationType operationType, int arg1, int arg2);

	BasicCalculator getCalculator();

	void setCalculator(BasicCalculator calculator);
}
