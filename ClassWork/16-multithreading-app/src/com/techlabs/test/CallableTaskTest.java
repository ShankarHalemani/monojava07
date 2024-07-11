package com.techlabs.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.techlabs.model.CallableTask;

public class CallableTaskTest {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);

		// if you used submit u need to create only one future to get
//		Future<Integer> future = service.submit(new CallableInterface());

		List<CallableTask> tasks = new ArrayList<CallableTask>();

		tasks.add(new CallableTask());
		tasks.add(new CallableTask());
		tasks.add(new CallableTask());
		tasks.add(new CallableTask());
		tasks.add(new CallableTask());

		try {
			// if u used invoke all u need to create list of futures to get
			List<Future<Integer>> futures = service.invokeAll(tasks);

			// if you used invoke any don't need to create future
//			System.out.println(service.invokeAny(tasks));

			for (Future<Integer> future : futures) {
				System.out.println(future.get());
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

//		try {
//			System.out.println(future.get());
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			e.printStackTrace();
//		}

	}

}
