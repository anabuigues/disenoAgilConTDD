package com.anabuigues.tdd.chapter9;

import java.util.List;

public interface Lexer {

	List<MathToken> getTokens(String expression);

	List<MathExpression> getExpressions(String expression);
}
