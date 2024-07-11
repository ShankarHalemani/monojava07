package com.techlabs.test;

import com.techlabs.model.MyThread;

public class MyThreadTest {

	public static void main(String[] args) {

		Thread.currentThread().setPriority(1);

		MyThread myThread1 = new MyThread("miniThread1");
		MyThread myThread2 = new MyThread("miniThread2");
		MyThread myThread3 = new MyThread("miniThread3");

		myThread1.setPriority(10);
		myThread2.setPriority(2);
		myThread3.setPriority(5);

		for (int i = 0; i <= 3; i++) {
			System.out.println(Thread.currentThread().getName() + " --> " + i);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
