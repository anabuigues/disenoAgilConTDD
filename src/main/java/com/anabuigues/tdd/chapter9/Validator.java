package com.anabuigues.tdd.chapter9;

public class Validator implements LimitsValidator {

	private int lowerLimit;
	private int upperLimit;

	public Validator(int lowerLimit, int upperLimit) {
		setLimits(lowerLimit, upperLimit);
	}
	
	@Override
	public void setLimits(int lowerLimit, int upperLimit) {
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
	}

	@Override
	public void validateArgs(int arg1, int arg2){
		breakIfOverflow(arg1, "First argument exceeds limits");
		breakIfOverflow(arg2, "Second argument exceeds limits");
	}	

	@Override
	public void validateResult(int result){
		breakIfOverflow(result, "Result exceeds limits");
	}	

	private void breakIfOverflow(int arg, String msg){
		if (ValueExceedLimits(arg))
			throw new OverflowException(msg);
	}

	public boolean ValueExceedLimits(int arg) {
		if (arg > upperLimit)
			return true;
		if (arg < lowerLimit)
			return true;
		return false;
	}

	public int getLowerLimit() {
		return lowerLimit;
	}

	public void setLowerLimit(int lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

	public int getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(int upperLimit) {
		this.upperLimit = upperLimit;
	}
}
