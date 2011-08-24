package com.anabuigues.tdd.chapter10;

public class UsersStorageManager {

	private FileHandler<UserFile> handler;

	public UsersStorageManager(FileHandler<UserFile> handler) {
		this.handler = handler;
	}

	public void setUsersFile(String path) {
		handler.createFile(path);
	}
}
