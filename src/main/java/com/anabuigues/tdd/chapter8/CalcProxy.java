package com.anabuigues.tdd.chapter8;

import java.lang.reflect.Method;

public class CalcProxy {

	private BasicCalculator calculator;
	private LimitsValidator validator;

	public CalcProxy(LimitsValidator validator, BasicCalculator calculator) {
		this.validator = validator;
		this.calculator = calculator;
	}

	public int binaryOperation(OperationType operationType, int arg1, int arg2) {
		int result = 0;

		Method method = null;
		try {
			method = calculator.getClass().getDeclaredMethod(
					operationType.name(), int.class, int.class);
			result = ((Integer) method.invoke(calculator, arg1, arg2))
					.intValue();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		validator.validateResult(result);
		return result;
	}
}
