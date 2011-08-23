package com.anabuigues.tdd.chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MathLexer implements Lexer {

	private static final char OPEN_SUBEXPRESSION = '(';
	private static final char CLOSE_SUBEXPRESSION = ')';
	private ExpressionFixer fixer;

	public MathLexer(ExpressionFixer fixer) {
		this.fixer = fixer;
	}

	@Override
	public List<MathToken> getTokens(String expression) {
		String[] items = splitExpression(expression);
		return createTokensFromStrings(items);
	}

	@Override
	public List<MathExpression> getExpressions(String expression) {
		int openedParenthesis = 0;
		ExpressionBuilder expBuilder = ExpressionBuilder.create();
		ExpressionBuilder.setInputText(expression);
		openedParenthesis = getExpressions(expBuilder, openedParenthesis);
		if (openedParenthesis != 0)
			throw new InvalidOperationException("Parenthesis do not match");
		fixer.fixExpressions(ExpressionBuilder.getAllExpressions());
		Collections.sort(ExpressionBuilder.getAllExpressions());
		return ExpressionBuilder.getAllExpressions();
	}

	private int getExpressions(ExpressionBuilder expBuilder, int openedParenthesis) {

		while (expBuilder.thereAreMoreChars()) {
			char currentChar = expBuilder.getCurrentChar();
			if (currentChar == OPEN_SUBEXPRESSION) {
				openedParenthesis++;
				openedParenthesis = getExpressions(expBuilder.processNewSubExpression(), openedParenthesis);
			} else if (currentChar == CLOSE_SUBEXPRESSION) {
				expBuilder.subExpressionEndFound();
				openedParenthesis--;
				return openedParenthesis;
			} else {
				expBuilder.addSubExpressionChar();
			}
		}
		expBuilder.subExpressionEndFound();
		return openedParenthesis;
	}

	private String[] splitExpression(String expression) {
		return expression.split("\\s+");
	}

	private List<MathToken> createTokensFromStrings(String[] items) {
		List<MathToken> tokens = new ArrayList<MathToken>();

		for (String item : items) {
			if (MathRegex.isOperator(item))
				tokens.add(OperatorFactory.create(item));
			else
				tokens.add(new MathNumber(item));
		}
		return tokens;
	}
}
