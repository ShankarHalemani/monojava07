package com.techlabs.model;

public class Rectangle implements Shape {
	private double width;
	private double height;

	public Rectangle(double width, double height) {

		this.width = width;
		this.height = height;
	}

	public void area() {
		System.out.println("Area of Rectangle is : " + width * height);
	}

	public void perimeter() {
		System.out.println("Perimeter of Rectangle is : " + ((2 * width) + (2 * height)));
	}

}
