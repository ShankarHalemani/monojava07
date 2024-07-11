package com.techlabs.streams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NumberOfCharsWordsLines {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileReader fileReader = new FileReader(
					"C:\\Users\\ACER\\Documents\\MonoJava\\06_Streams\\src\\com\\techlabs\\streams\\demo");
			int ch;
			int lineCount = 0;
			int wordCount = 0;
			int charCount = 0;

			while ((ch = fileReader.read()) != -1) {
				charCount++;

				if (ch == '\n') {
					lineCount++;
				}

				if (ch == ' ') {
					wordCount++;
				}

			}

			System.out.println("Line count : " + lineCount);
			System.out.println("Character count :" + charCount);
			System.out.println("Word count :" + wordCount);

			fileReader.close();

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
