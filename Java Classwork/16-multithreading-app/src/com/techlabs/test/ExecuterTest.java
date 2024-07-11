package com.techlabs.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.techlabs.model.Task;

public class ExecuterTest {

	public static void main(String[] args) {

		// Fixed Thread pool
//		int count = Runtime.getRuntime().availableProcessors();
//		System.out.println(count);
//
//		ExecutorService service1 = Executors.newFixedThreadPool(count);

		// Cached Thread pool
//		ExecutorService service2 = Executors.newCachedThreadPool();

		// Scheduled Thread pool
		ScheduledExecutorService service3 = Executors.newScheduledThreadPool(4);

//		for (int i = 0; i < 100; i++) {
//			// schedule() method used to schedule single task after specified time period,
//			// all the task after that single task follow how much time they take.
//			service3.schedule(new Task(), 3, TimeUnit.SECONDS);
//		}

//		for (int i = 0; i < 4; i++) {
//			// used to schedule tasks to run at particular interval, if they take more time
//			// than period period will be overrided by the time of execution of task, but
//			// they will execute at fixed rate
//			service3.scheduleAtFixedRate(new Task(), 1, 5, TimeUnit.SECONDS);
//		}

		for (int i = 0; i < 100; i++) {
			service3.scheduleWithFixedDelay(new Task(), 1, 5, TimeUnit.SECONDS);

		}

	}

}
