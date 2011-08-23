package com.anabuigues.tdd.chapter9;

public class OperatorFactory {

	public static MathOperator create(MathToken token) {
		return create(token.getToken());
	}

	public static MathOperator create(String token) {
		if (token.equals("*")) {
			return new MultiplyOperator();
		} else if (token.equals("/")) {
			return new DivideOperator();
		} else if (token.equals("+")) {
			return new AddOperator();
		} else if (token.equals("-")) {
			return new SubstractOperator();
		}
		throw new InvalidOperationException(
				"The given token is not a valid operator");
	}
}
