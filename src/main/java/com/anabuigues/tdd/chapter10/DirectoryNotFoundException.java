package com.anabuigues.tdd.chapter10;

public class DirectoryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DirectoryNotFoundException() {
	}

	public DirectoryNotFoundException(String arg0) {
		super(arg0);
	}

	public DirectoryNotFoundException(Throwable arg0) {
		super(arg0);
	}

	public DirectoryNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
}
