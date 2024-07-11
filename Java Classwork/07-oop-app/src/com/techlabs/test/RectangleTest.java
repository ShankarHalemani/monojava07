package com.techlabs.test;

import java.util.Scanner;

import com.techlabs.model.Rectangle;

public class RectangleTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int width;
		int height;

		Rectangle rectangle1 = new Rectangle();
		System.out.println("Enter rectangle width");
		width = scanner.nextInt();
		rectangle1.setWidth(width);

		System.out.println("Enter rectangle height");
		height = scanner.nextInt();
		rectangle1.setHeight(height);

		System.out.println("rectangle 1 details");
		System.out.println("rectangle width : " + rectangle1.getWidth());
		System.out.println("rectangle height : " + rectangle1.getHeight());
		rectangle1.calculateArea();

		System.out.println();

		Rectangle rectangle2 = new Rectangle();
		System.out.println("Enter rectangle width");
		width = scanner.nextInt();
		rectangle2.setWidth(width);

		System.out.println("Enter rectangle height");
		height = scanner.nextInt();
		rectangle2.setHeight(height);

		System.out.println("rectangle 2 details");
		System.out.println("rectangle width : " + rectangle2.getWidth());
		System.out.println("rectangle height : " + rectangle2.getHeight());
		rectangle2.calculateArea();

		scanner.close();
	}

}
