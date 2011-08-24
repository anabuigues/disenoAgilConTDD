package com.anabuigues.tdd.chapter10;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Test;

public class FileHandlerTests {

	@Test
	public void createFileWithWindowsPath() {
		String path = "/Users/animalaes/data.txt";
		UserFileHandler handler = new UserFileHandler();

		DataFile dataFile = handler.createFile(path);

		File file = new File(path);
		if (!file.exists()) {
			fail("File was not created");
		}
		assertNotNull(dataFile.getFile());
	}

	@Test
	public void createFileMultiPlatform() {
		String path = new EasyPath().getPlatformPath();
		UserFileHandler handler = new UserFileHandler();

		DataFile dataFile = handler.createFile(path);

		File file = new File(path);
		if (!file.exists()) {
			fail("File was not created");
		}
		assertNotNull(dataFile.getFile());
	}

	@Test(expected=DirectoryNotFoundException.class)
	public void createFileDirectoryNotFound() {
		String path = new NotFoundPath().getPlatformPath();
		UserFileHandler handler = new UserFileHandler();
		handler.createFile(path);
	}
}
