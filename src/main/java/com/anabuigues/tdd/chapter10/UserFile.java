package com.anabuigues.tdd.chapter10;

import java.io.File;

public class UserFile implements DataFile {

	private File file;

	@Override
	public File getFile() {
		return file;
	}

	@Override
	public void setFile(File file) {
		this.file = file;
	}
}
