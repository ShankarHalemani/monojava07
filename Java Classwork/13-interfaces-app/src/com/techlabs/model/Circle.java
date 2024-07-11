package com.techlabs.model;

public class Circle implements Shape {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public void area() {
		System.out.println("Area of circle is : " + 2 * 3.1412 * Math.pow(radius, 2));
	}

	public void perimeter() {
		System.out.println("Perimeter of circle is : " + 2 * 3.1412 * radius);
	}
}
