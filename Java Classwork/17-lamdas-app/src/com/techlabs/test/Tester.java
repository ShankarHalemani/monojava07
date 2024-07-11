package com.techlabs.test;

import com.techlabs.model.ITester;

public class Tester {

	public static void main(String[] args) {
		ITester tester = new ITester() {

			@Override
			public void test1() {
				System.out.println("Running test-1");

			}

			@Override
			public void test2() {
				System.out.println("Running test-2");

			}

		};

		tester.test1();
		tester.test2();

	}

}
