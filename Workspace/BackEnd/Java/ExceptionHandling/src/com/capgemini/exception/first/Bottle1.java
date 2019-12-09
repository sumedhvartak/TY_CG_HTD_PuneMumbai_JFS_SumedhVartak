package com.capgemini.exception.first;

import java.io.File;
import java.io.IOException;

public class Bottle1 {
	void open() throws IOException, ClassNotFoundException
	{
		File f = new File("D:/Sumedh.txt");
		f.createNewFile();
		
		Class.forName("com.capgemini.exception.first.Bottle1");
	}

}
