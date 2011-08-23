package com.anabuigues.tdd.chapter9;

import java.util.List;

public class Resolver {

	private Lexer lexer;
	private TokenPrecedence precedence;

	public Resolver(Lexer lexer, TokenPrecedence precedence) {
		this.lexer = lexer;
		this.precedence = precedence;
	}

	public int resolveSimpleExpression(String expression) {
		if (!MathRegex.isExpressionValid(expression))
			throw new InvalidOperationException(expression);

		List<MathToken> mathExp = lexer.getTokens(expression);
		while (mathExp.size() > 1) {
			MathToken op = precedence.getMaxPrecedence(mathExp);
			op.setPreviousToken(mathExp.get(op.getIndex() - 1));
			op.nextToken = (mathExp.get(op.getIndex() + 1));
			int result = op.resolve();
			replaceTokensWithResult(mathExp, op.getIndex(), result);
		}
		return mathExp.get(0).resolve();
	}

	private void replaceTokensWithResult(List<MathToken> tokens,
			int indexOfOperator, int result) {
		tokens.set(indexOfOperator -1 , new MathNumber(String.valueOf(result)));
		tokens.remove(indexOfOperator);
		tokens.remove(indexOfOperator);
	}
}
