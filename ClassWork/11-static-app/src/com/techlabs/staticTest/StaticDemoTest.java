package com.techlabs.staticTest;

import com.techlabs.model.StaticDemo;

public class StaticDemoTest {

	public static void main(String[] args) {
		StaticDemo staticDemo1 = new StaticDemo();
		staticDemo1.display();

		StaticDemo staticDemo2 = new StaticDemo();
		staticDemo2.display();

		StaticDemo staticDemo3 = new StaticDemo();
		staticDemo3.display();

		staticDemo1.increament();
		staticDemo1.display();

		StaticDemo.decreament();

		staticDemo2.increament();
		staticDemo2.display();

		staticDemo3.increament();
		staticDemo3.display();

//		Non static block
		{
			System.out.println("Non static block in StaticDemoTest class inside main method");
		}

	}

	static {
		System.out.println("Static block in StaticDemoTest class");
	}

}
