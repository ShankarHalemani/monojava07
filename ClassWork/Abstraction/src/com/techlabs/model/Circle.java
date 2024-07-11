package com.techlabs.model;

public class Circle extends Shape {
	private double radius;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public void area() {
		double area = 2 * 3.1412 * Math.pow(radius, 2);
		System.out.println("Area of circle : " + area);
	}
}
