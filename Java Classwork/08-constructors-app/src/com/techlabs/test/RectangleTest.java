package com.techlabs.test;

import com.techlabs.model.Rectangle;

public class RectangleTest {

	public static void main(String[] args) {
		Rectangle rectangle1 = new Rectangle();
		System.out.println("Rectangle details");
		System.out.println("rectangle width : " + rectangle1.getWidth());
		System.out.println("Rectangle height : " + rectangle1.getHeight());
		System.out.println("Rectangle area : " + rectangle1.getArea());
		System.out.println();

		Rectangle rectangle2 = new Rectangle(40, 50);
		System.out.println("Rectangle details");
		System.out.println("rectangle width : " + rectangle2.getWidth());
		System.out.println("Rectangle height : " + rectangle2.getHeight());
		System.out.println("Rectangle area : " + rectangle2.getArea());
		System.out.println();

		Rectangle rectangle3 = new Rectangle(30);
		System.out.println("Rectangle details");
		System.out.println("rectangle width : " + rectangle3.getWidth());
		System.out.println("Rectangle height : " + rectangle3.getHeight());
		System.out.println("Rectangle area : " + rectangle3.getArea());

	}

}
