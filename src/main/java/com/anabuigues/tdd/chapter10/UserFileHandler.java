package com.anabuigues.tdd.chapter10;

import java.io.File;
import java.io.IOException;

public class UserFileHandler implements FileHandler<UserFile> {

	@Override
	public UserFile createFile(String path) {
		File file = new File(path);
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		UserFile userFile = new UserFile();
		userFile.setFile(file);
		return userFile;
	}

}
