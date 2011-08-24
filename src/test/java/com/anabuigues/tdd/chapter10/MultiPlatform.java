package com.anabuigues.tdd.chapter10;

public abstract class MultiPlatform {

	public abstract String getPOSIXpath();

	public abstract String getWindowsPath();

	public String getPlatformPath() {
		String osInfo = System.getProperty("os.name").toLowerCase();
		String path = "";

		if (osInfo.contains("unix")) {
			path = getPOSIXpath();
		} else if (osInfo.contains("mac")) {
			path = getPOSIXpath();
		} else {
			path = getWindowsPath();
		}
		return path;
	}
}
