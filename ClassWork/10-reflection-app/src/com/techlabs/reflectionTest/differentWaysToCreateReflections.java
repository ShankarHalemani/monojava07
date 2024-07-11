package com.techlabs.reflectionTest;

import java.lang.reflect.Method;

class Dog {

	private int legs;
	private int eyes;

	public void Display() {
		System.out.println("Dog class");
	}

	public void dogBody(int legs, int eyes) {
		this.legs = legs;
		this.eyes = eyes;
	}
}

public class differentWaysToCreateReflections {

	public static void main(String[] args) {

//		Using .class literal
		Class reflection1 = Dog.class;

		System.out.println(reflection1.getName());

//		Using object.getClass() method
		Dog d1 = new Dog();
		Class reflection2 = d1.getClass();

		System.out.println(reflection2.getSimpleName());

//		Using clasLoader.loadClass() method
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			Class reflection3 = classLoader.loadClass("com.techlabs.reflectionTest.Dog");
			Method methods[] = reflection3.getMethods();

			for (Method method : methods) {
				System.out.println(method.getName() + "\t" + method.getParameterCount());
			}
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

//		Using .class literal
		Class reflection4 = String.class;
		System.out.println(reflection1.getName());

//		Using object.getClass() method
		String str1 = new String("ABC");
		Class reflection5 = str1.getClass();
		System.out.println(reflection2.getSimpleName());

//		Using clasLoader.loadClass() method
		try {
			Class reflection6 = classLoader.loadClass("java.lang.String");
			Method methods[] = reflection6.getMethods();

			for (Method method : methods) {
				System.out.println(method.getName() + "\t" + method.getParameterCount());
			}
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
