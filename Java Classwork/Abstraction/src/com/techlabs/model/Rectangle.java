package com.techlabs.model;

public class Rectangle {
	private double height;
	private double width;

	public Rectangle(double height, double width) {
		super();
		this.height = height;
		this.width = width;
	}

	public void area() {
		double area = width * height;
		System.out.println("Area of rectangle : " + area);
	}
}
