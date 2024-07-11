package com.techlabs.isp.violation.model;

public class Labour implements IWorker {

	@Override
	public void startWork() {
		System.out.println("Labour started Working");

	}

	@Override
	public void stopWork() {
		System.out.println("Labour stopped Working");

	}

	@Override
	public void eat() {
		System.out.println("Labour is eating");

	}

	@Override
	public void drink() {
		System.out.println("Labour is drinking");

	}

}
