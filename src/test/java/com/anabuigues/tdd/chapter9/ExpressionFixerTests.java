package com.anabuigues.tdd.chapter9;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExpressionFixerTests {

	private ExpressionFixer fixer;
	private List<MathExpression> expressions;

	@Before
	public void setUp() throws Exception {
		fixer = new ExpressionFixer();
		expressions = new ArrayList<MathExpression>();
	}

	@Test
	public void splitExpressionWhenOperatorAtTheEnd() {
		expressions.add(new MathExpression("2 +"));
		fixer.fixExpressions(expressions);
		assertTrue(expressions.get(0).getExpression().equals("2")
				|| expressions.get(0).getExpression().equals("+"));
		assertTrue(expressions.get(1).getExpression().equals("2")
				|| expressions.get(1).getExpression().equals("+"));
	}

	@Test
	public void trim() {
		expressions.add(new MathExpression(" * "));
		fixer.fixExpressions(expressions);
		assertEquals("*", expressions.get(0).getExpression());
	}

	@Test
	public void builderTests() {
		ExpressionBuilder builder = ExpressionBuilder.create();
		ExpressionBuilder.setInputText("hola");
		ExpressionBuilder.setCurrentIndex(1);

		ExpressionBuilder builder2 = builder.processNewSubExpression();
		assertEquals(ExpressionBuilder.getCurrentIndex(), 2);
		assertEquals(ExpressionBuilder.getInputText(), "hola");

		builder2.processNewSubExpression();
		assertEquals(ExpressionBuilder.getCurrentIndex(), 3);
		assertEquals(ExpressionBuilder.getInputText(), "hola");

		assertEquals(ExpressionBuilder.getCurrentIndex(), 3);
	}
}
