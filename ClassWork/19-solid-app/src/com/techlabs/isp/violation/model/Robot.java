package com.techlabs.isp.violation.model;

public class Robot implements IWorker {
	@Override
	public void startWork() {
		System.out.println("Robot started Working");

	}

	@Override
	public void stopWork() {
		System.out.println("Robot stopped Working");

	}

	@Override
	public void eat() {
		System.out.println("Robot is eating");

	}

	@Override
	public void drink() {
		System.out.println("Robot is drinking");

	}
}
