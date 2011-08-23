package com.anabuigues.tdd.chapter9;

import java.util.List;

public interface TokenPrecedence {

	MathToken getMaxPrecedence(List<MathToken> tokens);
}
