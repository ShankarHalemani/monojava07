package com.techlabs.model;

public class Task implements Runnable {
	@Override
	public void run() {
		long currentTime = System.currentTimeMillis() / 1000;
		System.out.println("Thread" + " --> " + Thread.currentThread().getName() + " --> " + currentTime);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
