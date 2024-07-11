package com.techlabs.model;

public class Rectangle {
	private int width;
	private int height;

	public void setWidth(int rwidth) {
		width = rwidth;
	}

	public void setHeight(int rheight) {
		height = rheight;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void calculateArea() {
		int area = width * height;
		System.out.println("Area of rectangle : " + area);
	}
}
