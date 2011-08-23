package com.anabuigues.tdd.chapter9;

public class MathExpression implements Comparable<MathExpression> {

	private String expression;
	private int order;

	public MathExpression(String expression) {
		this.expression = expression;
		this.order = -1;
	}

	public MathExpression(String expression, int order) {
		this.expression = expression;
		this.order = order;
	}

	public boolean IsEmpty() {
		return expression.length() == 0;
	}

	@Override
	public int compareTo(MathExpression me) {
		Integer iOrder = new Integer(order);
		return iOrder.compareTo(me.getOrder());
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
}
