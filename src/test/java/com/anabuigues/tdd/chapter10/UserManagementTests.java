package com.anabuigues.tdd.chapter10;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

//Estos son test unitarios no de integracion
public class UserManagementTests {

	@Test
	public void configUsersFile() {
		String filePath = "/Users/animalaes/data.txt ";

		FileHandler<UserFile> handlerMock = mock(FileHandler.class);
		when(handlerMock.createFile(filePath)).thenReturn(new UserFile());

		UsersStorageManager manager = new UsersStorageManager(handlerMock);
		manager.setUsersFile(filePath);

		verify(handlerMock).createFile(filePath);
	}

	@Test(expected = DirectoryNotFoundException.class)
	public void tryCreateFileWhenDirectoryNotFound() throws Exception {
		FileHandler<UserFile> handlerMock = mock(FileHandler.class);

		when(handlerMock.createFile("")).thenThrow(
				new DirectoryNotFoundException());

		UsersStorageManager manager = new UsersStorageManager(handlerMock);
		manager.setUsersFile("");
	}
}
