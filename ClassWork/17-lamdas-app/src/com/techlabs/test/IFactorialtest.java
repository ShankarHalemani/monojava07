package com.techlabs.test;

import com.techlabs.model.IFactorial;

public class IFactorialtest {

	public static void main(String[] args) {
//		IFactorial factorial = (int number) -> {
//			int factor = 1;
//			while (number > 0) {
//				factor *= number;
//				number--;
//			}
//
//			return factor;
//		};

//		System.out.println("Factorial : " + factorial.fact(5));

		System.out.println(fun((int number) -> {
			int factor = 1;
			while (number > 0) {
				factor *= number;
				number--;
			}

			return factor;
		}));

	}

	private static int fun(IFactorial factorial) {
		return factorial.fact(5);

	}

}
