package com.anabuigues.tdd.chapter9;

public class InvalidOperationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidOperationException() {
	}

	public InvalidOperationException(String arg0) {
		super(arg0);
	}

	public InvalidOperationException(Throwable arg0) {
		super(arg0);
	}

	public InvalidOperationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
}
