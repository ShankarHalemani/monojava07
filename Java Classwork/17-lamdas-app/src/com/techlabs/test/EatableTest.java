package com.techlabs.test;

import com.techlabs.model.Eatable;

public class EatableTest {

	public static void main(String[] args) {
		Eatable eatable = () -> {
			System.out.println("Eating");
			System.out.println("Eating...");
		};

		eatable.eat();

	}

}
