package com.anabuigues.tdd.chapter10;

public interface FileHandler<T extends DataFile> {

	T createFile(String path);
}
