package com.anabuigues.tdd.chapter9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LexerTests {

	private MathLexer lexer;
	private ExpressionFixer fixer;

	@Before
	public void setUp() throws Exception {
		fixer = new ExpressionFixer();
		lexer = new MathLexer(fixer);
	}

	@Test
	public void getTokens() {
		List<MathToken> tokens = lexer.getTokens("2 + 2");

		assertEquals(3, tokens.size());
		assertEquals("2", tokens.get(0).getToken());
		assertEquals("+", tokens.get(1).getToken());
		assertEquals("2", tokens.get(2).getToken());
	}

	@Test
	public void getTokensLongExpression() {
		List<MathToken> tokens = lexer.getTokens("2 - 1 + 3");

		assertEquals(5, tokens.size());
		assertEquals("+", tokens.get(3).getToken());
		assertEquals("3", tokens.get(4).getToken());
	}

	@Test
	public void getTokensWithSpaces() {
		List<MathToken> tokens = lexer.getTokens("5 -   88");

		assertEquals("5", tokens.get(0).getToken());
		assertEquals("-", tokens.get(1).getToken());
		assertEquals("88", tokens.get(2).getToken());
	}
	
	@Test
	public void getTokensRightSubclasses() {
		List<MathToken> tokens = lexer.getTokens("2 + 2");
		assertTrue(tokens.get(0) instanceof MathNumber);
		assertTrue(tokens.get(1) instanceof MathOperator);
	}

	@Test
	public void getExpressionsWith1Parenthesis() {
		List<MathExpression> expressions = lexer.getExpressions("(2 + 2)");
		assertEquals(1, expressions.size());
		assertEquals("2 + 2", expressions.get(0).getExpression());
	}

	@Test
	public void getExpressionsWithNestedParenthesis() {
		List<MathExpression> expressions = lexer.getExpressions("((2) + 2)");
		failIfOtherSubExpressionThan(expressions, "2", "+");
	}

	@Test
	public void getNestedExpressions() {
		List<MathExpression> expressions = lexer.getExpressions("((2 + 1) + 2)");
		assertEquals(3, expressions.size());
		failIfOtherSubExpressionThan(expressions, "2 + 1", "+", "2");
	}
	
	@Test
	public void getExpressionWithParenthesisAtTheEnd() {
		List<MathExpression> expressions = lexer.getExpressions("2 + (3 * 1)");
		failIfOtherSubExpressionThan(expressions, "3 * 1", "+", "2");
	}
	
	@Test
	public void throwExceptionOnOpenParenthesis() {
		try {
			lexer.getExpressions("2 + (3 * 1");
			fail("Exception didn ’t arise!");
		} catch (InvalidOperationException ioEx) {

		}
	}

	@Test
	public void getExpressionWithTwoGroups() {
		List<MathExpression> expressions = lexer.getExpressions("(2 + 2) * (3 + 1)");
		failIfOtherSubExpressionThan(expressions, "3 + 1", "2 + 2", "*");
	}
	
	@Test
	public void getComplexNestedExpressions() {
		List<MathExpression> expressions = lexer.getExpressions("((2 + 2) + 1)  * (3 + 1)");
		failIfOtherSubExpressionThan(expressions, "3 + 1", "2 + 2", "+", "*", "1");
	}
	
	@Test
	public void getSeveralParenthesisExpressionsInOrder() {
		List<MathExpression> expressions = lexer.getExpressions("(2 + 2) * (3 + 1)");
		for(MathExpression exp : expressions ){
			System.out.println("x:" + exp + ".");
		}
		assertEquals("2 + 2", expressions.get(0).getExpression());
		assertEquals("*", expressions.get(1).getExpression());
		assertEquals("3 + 1", expressions.get(2).getExpression());
	}
	
	private void failIfOtherSubExpressionThan(List<MathExpression> expressions,
			String... expectedSubExpressions) {
		boolean isSubExpression = false;
		for(String subExpression : expectedSubExpressions){
			isSubExpression= false;
			for(MathExpression exp : expressions){
				if(exp.getExpression().equals(subExpression)){
					isSubExpression = true;
					break;
				}
			}
			if(!isSubExpression){
				fail("Wrong expression split: " + subExpression);
			}
		}
	}
}
