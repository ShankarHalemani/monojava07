package com.techlabs.streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "C:\\Users\\ACER\\Documents\\MonoJava\\06_Streams\\src\\com\\techlabs\\streams\\demo";
		try {
			FileInputStream fileInputStream = new FileInputStream(filePath);
			int ch;
			while ((ch = fileInputStream.read()) != -1) {
				System.out.print((char) ch);
			}
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
