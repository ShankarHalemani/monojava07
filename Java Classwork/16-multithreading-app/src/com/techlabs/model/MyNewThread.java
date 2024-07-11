package com.techlabs.model;

public class MyNewThread implements Runnable {
	public Thread thread;

	public MyNewThread(String name) {
		this.thread = new Thread(this, name);
		thread.start();
	}

	@Override
	public void run() {
		for (int i = 0; i <= 3; i++) {
			System.out.println(Thread.currentThread().getName() + " --> " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
