package com.anabuigues.tdd.chapter9;

public abstract class MathToken {

	protected int precedence = 0;
	protected String token = "";
	protected int index = -1;
	protected MathToken previousToken;
	protected MathToken nextToken;

	public MathToken(String token) {
		this.token = token;
	}

	public MathToken(int precedence) {
		this.precedence = precedence;
	}

	public abstract int resolve();

	public String getToken() {
		return token;
	}

	public int getPrecedence() {
		return precedence;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public MathToken getPreviousToken() {
		return previousToken;
	}

	public void setPreviousToken(MathToken previousToken) {
		this.previousToken = previousToken;
	}

	public MathToken getNextToken() {
		return nextToken;
	}

	public void setNextToken(MathToken nextToken) {
		this.nextToken = nextToken;
	}
}
