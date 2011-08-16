package com.anabuigues.tdd.chapter8;

public class OverflowException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OverflowException() {
	}

	public OverflowException(String arg0) {
		super(arg0);
	}

	public OverflowException(Throwable arg0) {
		super(arg0);
	}

	public OverflowException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
}
