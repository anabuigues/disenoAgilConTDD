package com.anabuigues.tdd.chapter9;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MathRegexTests {

	@Test
	public void validateMostSimpleExpression() {
		String expression = "25 + 287";
		boolean result = MathRegex.isExpressionValid(expression);
		assertTrue(result);
	}

	@Test
	public void validateWithSpaces() {
		String expression = "25  +   287";
		boolean result = MathRegex.isExpressionValid(expression);
		assertTrue(result);
	}

	@Test
	public void validateFailsNoSpaces() {
		String expression = "25+287";
		boolean result = MathRegex.isExpressionValid(expression);
		assertTrue(result);
	}

	@Test
	public void validateComplexExpression() {
		String expression = "2 + 7 - 2 * 4";
		boolean result = MathRegex.isExpressionValid(expression);
		assertTrue(result);
	}

	@Test
	public void validateComplexWrongExpression() {
		String expression = "2 + 7 a 2 * 4";
		boolean result = MathRegex.isExpressionValid(expression);
		assertFalse(result);
	}

	@Test
	public void validateSimpleWrongExpression() {
		String expression = "2a7";
		boolean result = MathRegex.isExpressionValid(expression);
		assertFalse(result);
	}

	@Test
	public void validateWrongExpressionWithValidSubexpression() {
		String expression = "2 + 7 - 2 a 3 b";
		boolean result = MathRegex.isExpressionValid(expression);
		assertFalse(result);
	}

	@Test
	public void validateWithSeveralOperatorsTogether() {
		String expression = "+ + 7";
		boolean result = MathRegex.isExpressionValid(expression);
		assertFalse(result);
	}

	@Test
	public void validateWithNegativeNumers() {
		String expression = "-7 + 1";
		boolean result = MathRegex.isExpressionValid(expression);
		assertTrue(result);
	}

	@Test
	public void validateWithNegativeNumersAtTheEnd() {
		String expression = "7 -  -1";
		boolean result = MathRegex.isExpressionValid(expression);
		assertTrue(result);
	}

	@Test
	public void validateSuperComplexExpression() {
		String expression = "-7 -  -1 * 2 / 3 +  -5";
		boolean result = MathRegex.isExpressionValid(expression);
		assertTrue(result);
	}

	@Test
	public void validateSimpleExpressionWithAllOperators() {
		String operators = "+-*/";
		String expression = null;

		for (int i = 0; i < operators.length(); i++) {
			expression = "2 " + operators.charAt(i) + " 2";
			assertTrue("Failure with operator: " + operators.charAt(i),
					MathRegex.isExpressionValid(expression));
		}
	}

	@Test
	public void isNumber() {
		assertTrue(MathRegex.isNumber("22"));
	}

	@Test
	public void IsOperator() {
		String operators = "*+/-";
		for (char op : operators.toCharArray())
			assertTrue(MathRegex.isOperator(String.valueOf(op)));
	}

	@Test
	public void IsSubExpression() {
		assertTrue(MathRegex.isSubExpression("2 + 2"));
	}
}
