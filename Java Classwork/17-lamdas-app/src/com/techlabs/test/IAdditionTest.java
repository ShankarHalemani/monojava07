package com.techlabs.test;

import com.techlabs.model.IAddition;

public class IAdditionTest {

	public static void main(String[] args) {
//		IAddition adder = (int a, int b) -> {
//			return a + b;
//		};
//
//		System.out.println("Sum : " + adder.add(10, 20));
//	}

		System.out.println(fun((int a, int b) -> {
			return a + b;
		}));

	}

	private static int fun(IAddition adder) {
		return adder.add(10, 20);

	}
}