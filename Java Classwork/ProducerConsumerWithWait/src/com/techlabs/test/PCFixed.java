package com.techlabs.test;

import com.techlabs.model.Consumer;
import com.techlabs.model.Producer;
import com.techlabs.model.Q;

public class PCFixed {

	public static void main(String[] args) {
		Q q = new Q();
		new Producer(q);
		new Consumer(q);
		System.out.println("Press Control-C to stop.");
	}

}
