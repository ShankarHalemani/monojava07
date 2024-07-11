package com.techlabs.test;

import com.techlabs.model.MyNewThread;

public class MyNewThreadJoinTest {

	public static void main(String[] args) throws InterruptedException {
		MyNewThread myNewThread1 = new MyNewThread("T1");
		MyNewThread myNewThread2 = new MyNewThread("T2");
		MyNewThread myNewThread3 = new MyNewThread("T3");

		System.out.println(myNewThread1.thread.isAlive());
		System.out.println(myNewThread2.thread.isAlive());
		System.out.println(myNewThread3.thread.isAlive());

		for (int i = 3; i >= 0; i--) {
			System.out.println(Thread.currentThread().getName() + " ---> " + i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		myNewThread1.thread.join();
		myNewThread2.thread.join();
		myNewThread3.thread.join();

		System.out.println(myNewThread1.thread.isAlive());
		System.out.println(myNewThread2.thread.isAlive());
		System.out.println(myNewThread3.thread.isAlive());

		System.out.println("Exiting main");

	}

}
