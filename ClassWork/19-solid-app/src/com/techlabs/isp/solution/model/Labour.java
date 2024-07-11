package com.techlabs.isp.solution.model;

public class Labour implements IWorker {

	@Override
	public void eat() {
		System.out.println("Labour is eating");

	}

	@Override
	public void rest() {
		System.out.println("Labour is resting");

	}

	@Override
	public void start() {
		System.out.println("Labour started working");

	}

	@Override
	public void stop() {
		System.out.println("Labour stopped working");

	}

}
