package com.anabuigues.tdd.chapter9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class CalcProxyTests {

	private BasicCalculator calculator;
	private CalcProxy calcProxy;
	private CalcProxy calcProxyWithLimits;

	@Before
	public void setUp() throws Exception {
		calculator = new Calculator();
		calcProxy = new CalcProxy(new Validator(-100, 100), calculator);
		calcProxyWithLimits = new CalcProxy(new Validator(-10, 10), calculator);
	}

	@Test
	public void add() {
		int result = calcProxy.binaryOperation(OperationType.add, 2, 2);
		assertEquals(4, result);
	}

	@Test
	public void substract() {
		int result = calcProxy.binaryOperation(OperationType.substract, 5, 3);
		assertEquals(2, result);
	}

	@Test
	public void addWithDifferentArguments() {
		int result = calculator.add(2, 5);
		assertEquals(7, result);
	}

	@Test
	public void substractReturningNegative() throws OverflowException {
		int result = calculator.substract(3, 5);
		assertEquals(-2, result);
	}

	@Test
	public void argumentsExceedLimits() {
		try {
			calcProxyWithLimits.binaryOperation(OperationType.add, 30, 50);
			fail("This should fail as arguments exceed both limits ");
		} catch (OverflowException oEx) {
			// Ok, this works
		}
	}

	@Test
	public void ArgumentsExceedLimitsInverse() {
		try {
			calcProxyWithLimits.binaryOperation(OperationType.add, -30, -50);
			fail("This should fail as arguments exceed both limits");
		} catch (OverflowException oEx) {
			// Ok, this works
		}
	}

	@Test
	public void ValidateResultExceedingUpperLimit() {
		try {
			calcProxyWithLimits.binaryOperation(OperationType.add, 10, 10);
			fail("This should fail as result exceed upper limit");
		} catch (OverflowException oEx) {
			// Ok, this works
		}
	}

	@Test
	public void ValidateResultExceedingLowerLimit() {
		try {
			calcProxyWithLimits.binaryOperation(OperationType.add, -20, -1);
			fail("This should fail as result exceed lower limit");
		} catch (OverflowException oEx) {
			// Ok, this works
		}
	}
	
	@Test
	public void multiply() {
		int result = calcProxy.binaryOperation(OperationType.multiply, 2, 5);
		assertEquals(10, result);
	}
	
	@Test
	public void divide() {
		int result = calcProxy.binaryOperation(OperationType.divide, 10, 2);
		assertEquals(5, result);
	}
}
