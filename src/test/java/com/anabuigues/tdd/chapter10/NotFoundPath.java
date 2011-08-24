package com.anabuigues.tdd.chapter10;

public class NotFoundPath extends MultiPlatform {

	@Override
	public String getPOSIXpath() {
		return "/asdflwiejawseras/data.txt";
	}

	@Override
	public String getWindowsPath() {
		return "C:\\asdfalsdfkwjerasdfas\\data.txt";
	}
}
