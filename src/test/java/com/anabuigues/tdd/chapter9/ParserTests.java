package com.anabuigues.tdd.chapter9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class ParserTests {

	private MathLexer lexer;
	private ExpressionFixer fixer;
	private MathParser parser;
	private Resolver resolver;

	@Before
	public void setUp() throws Exception {
		fixer = new ExpressionFixer();
		lexer = new MathLexer(fixer);
		resolver = new Resolver(lexer, new Precedence());
		parser = new MathParser(lexer, resolver);
	}

	@Test
	public void processSimpleExpression() {
		assertEquals(4, parser.processExpression("2 + 2"));
	}

	/*
	 * @Test public void parserWorksWithCalcProxy() { List<MathToken> tokens =
	 * new ArrayList<MathToken>(); tokens.add(new MathToken("2"));
	 * tokens.add(new MathToken("+")); tokens.add(new MathToken("2"));
	 * 
	 * Lexer lexerMock = mock(Lexer.class);
	 * when(lexerMock.getTokens("2 + 2")).thenReturn(tokens);
	 * 
	 * CalculatorProxy calcProxyMock = mock(CalculatorProxy.class);
	 * 
	 * when(calcProxyMock.getCalculator()).thenReturn(calculator);
	 * when(calcProxyMock.binaryOperation(OperationType.add, 2, 2))
	 * .thenReturn(4);
	 * 
	 * MathParser parser = new MathParser(lexerMock, calcProxyMock);
	 * parser.processExpression("2 + 2");
	 * 
	 * verify(calcProxyMock).binaryOperation(OperationType.add, 2, 2); }
	 * 
	 * @Test public void parserWorksWithLexer() { List<MathToken> tokens = new
	 * ArrayList<MathToken>(); tokens.add(new MathToken("2")); tokens.add(new
	 * MathToken("+")); tokens.add(new MathToken("2"));
	 * 
	 * Lexer lexerMock = mock(Lexer.class);
	 * when(lexerMock.getTokens("2 + 2")).thenReturn(tokens);
	 * 
	 * MathParser parser = new MathParser(lexerMock, new CalcProxy( new
	 * Validator(-100, 100), new Calculator()));
	 * parser.processExpression("2 + 2");
	 * 
	 * verify(lexerMock).getTokens("2 + 2"); }
	 */

	@Test
	public void processExpression2Operators() {
		assertEquals(6, parser.processExpression("3 + 1 + 2"));
	}

	@Test
	public void processExpressionWithPrecedence() {
		assertEquals(9, parser.processExpression("3 + 3 * 2"));
	}

	@Test
	public void processAcceptanceExpression() {
		assertEquals(9, parser.processExpression("5 + 4 * 2 / 2"));
	}

	@Test
	public void processAcceptanceExpressionWithAllOperators() {
		assertEquals(8, parser.processExpression("5 + 4 - 1 * 2 / 2"));
	}

	@Test
	public void processAcceptanceExpressionWithParenthesis() {
		assertEquals(16, parser.processExpression("(2 + 2) * (3 + 1)"));
	}

	@Test
	public void ProcessComplexNestedExpressions() {
		assertEquals(20, parser.processExpression("((2 + 2) + 1)  * (3 + 1)"));
	}

	@Test
	public void TryProcessWrongExpression() {
		try {
			parser.processExpression("2 - 1++ 3");
			fail("Exception did not arise!");
		} catch (InvalidOperationException ioEx) {
		}
	}
}
