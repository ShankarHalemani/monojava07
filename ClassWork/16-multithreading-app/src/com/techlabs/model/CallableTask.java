package com.techlabs.model;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
}
