package com.techlabs.test;

import java.util.Scanner;

import com.techlabs.model.Circle;
import com.techlabs.model.Rectangle;
import com.techlabs.model.Shape;

public class ShapeTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter radius of circle");
		double radius = scanner.nextDouble();

		Shape shape;

		shape = new Circle(radius);
		shape.area();
		shape.perimeter();

		System.out.println("Enter Width of rectangle");
		double width = scanner.nextDouble();
		System.out.println("Enter height of rectangle");
		double height = scanner.nextDouble();

		shape = new Rectangle(width, height);
		shape.area();
		shape.perimeter();

		scanner.close();
	}

}
