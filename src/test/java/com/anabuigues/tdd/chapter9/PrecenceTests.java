package com.anabuigues.tdd.chapter9;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class PrecenceTests {

	@Test
	public void getMaxPrecedence() {
		MathLexer lexer = new MathLexer(new ExpressionFixer());
		List<MathToken> tokens = lexer.getTokens("3 + 3 * 2");
		Precedence precedence = new Precedence();
		MathToken op = precedence.getMaxPrecedence(tokens);
		assertEquals(op.getToken(), "*");
	}
}
