package com.anabuigues.tdd.chapter9;

import java.util.List;

public class MathParser {

	private Lexer lexer;
	private Resolver resolver;
	
	public MathParser(Lexer lexer, Resolver resolver) {
		this.lexer = lexer;
		this.resolver = resolver;
	}

	public int processExpression(String expression) {
		List<MathExpression> subExpressions = lexer.getExpressions(expression);
		String flatExpression = "";
		for (MathExpression subExp : subExpressions) {
			if (MathRegex.isSubExpression(subExp.getExpression())) {
				flatExpression += resolver.resolveSimpleExpression(subExp.getExpression());
			} else {
				flatExpression += " " + subExp.getExpression() + " ";
			}
		}
		return resolver.resolveSimpleExpression(flatExpression);
	}
}
