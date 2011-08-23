package com.anabuigues.tdd.chapter9;

import static org.junit.Assert.*;

import org.junit.Test;

public class OperatorFactoryTests {

	@Test
	public void createMultiplyOperator() {
		MathOperator op = OperatorFactory.create("*");
		assertEquals(op.getPrecedence(), 2);
	}
	
	@Test
	public void createDivisionOperator() {
		MathOperator op = OperatorFactory.create("/");
		assertEquals(op.getPrecedence(), 2);
	}
	
	@Test
	public void createAddOperator() {
		MathOperator op = OperatorFactory.create("+");
		assertEquals(op.getPrecedence(), 1);
	}
}
