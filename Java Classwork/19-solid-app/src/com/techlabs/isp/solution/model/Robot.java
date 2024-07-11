package com.techlabs.isp.solution.model;

public class Robot implements IWorkable {

	@Override
	public void start() {
		System.out.println("Robot started working");
	}

	@Override
	public void stop() {
		System.out.println("Robot stopped working");
	}

}
