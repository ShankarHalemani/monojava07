package com.techlabs.model;

public class MyThread extends Thread {

	public MyThread(String name) {
		super(name);
		start();
	}

	@Override
	public void run() {
		for (int i = 0; i <= 3; i++) {
			System.out.println(Thread.currentThread().getName() + " --> " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
