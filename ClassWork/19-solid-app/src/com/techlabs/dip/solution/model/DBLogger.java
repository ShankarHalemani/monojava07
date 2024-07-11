package com.techlabs.dip.solution.model;

public class DBLogger implements ILogger {

	@Override
	public void log(String error) {
		System.out.println("Logged to Database : " + error);
	}
}
