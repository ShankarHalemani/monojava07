package com.techlabs.dip.solution.model;

public class FileLogger implements ILogger {
	@Override
	public void log(String error) {
		System.out.println("Logged to File : " + error);
	}
}
