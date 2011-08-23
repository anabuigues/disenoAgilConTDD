package com.anabuigues.tdd.chapter9;

public abstract class MathOperator extends MathToken {

	protected CalculatorProxy calcProxy;
	
	public MathOperator(int precedence) {
		super(precedence);
		calcProxy = new CalcProxy(new Validator(-100, 100), new Calculator());
	}

	public abstract int resolve(int a, int b);

	@Override
	public int resolve() {
		return resolve(previousToken.resolve(), nextToken.resolve());
	}

	public CalculatorProxy getCalcProxy() {
		return calcProxy;
	}

	public void setCalcProxy(CalculatorProxy calcProxy) {
		this.calcProxy = calcProxy;
	}
}
