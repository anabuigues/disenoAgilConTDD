package com.anabuigues.tdd.chapter9;

import java.util.List;

public class Precedence implements TokenPrecedence {

	@Override
	public MathToken getMaxPrecedence(List<MathToken> tokens) {
		int precedence = 0;
		MathToken maxPrecedenceToken = null;

		int index = -1;
		for (MathToken token : tokens) {
			index++;
			if (token.getPrecedence() >= precedence) {
				precedence = token.getPrecedence();
				maxPrecedenceToken = token;
				maxPrecedenceToken.setIndex(index);
			}
		}
		return maxPrecedenceToken;
	}

}
