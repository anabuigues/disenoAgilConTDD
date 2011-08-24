package com.anabuigues.tdd.chapter10;

public class EasyPath extends MultiPlatform{

	@Override
	public String getPOSIXpath() {
		return "/tmp/data.txt";
	}

	@Override
	public String getWindowsPath() {
		return "C:\\data.txt";
	}

}
