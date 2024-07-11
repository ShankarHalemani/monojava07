package com.techlabs.reflectionTest;

import java.lang.reflect.Method;

public class ReflectionOfString {

	public static void main(String[] args) {
		try {
			Class stringClass = Class.forName("java.lang.String");
//
//			System.out.println(stringClass.getName());
//			System.out.println(stringClass.getSimpleName());
//			System.out.println(stringClass.getTypeName());
//
//			Constructor constructors[] = stringClass.getConstructors();
//
//			for (Constructor constructor : constructors) {
//				System.out.println(constructor.getName());
//				System.out.println(constructor.getParameterCount());
//
//				Parameter parameters[] = constructor.getParameters();
//
//				for (Parameter parameter : parameters) {
//					System.out.println(parameter.getName() + "\t" + parameter.getParameterizedType());
//
//				}
//			}

			Method methods[] = stringClass.getMethods();

			for (Method method : methods) {
				System.out.println(method.getName() + "\t" + method.getParameterCount());
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
