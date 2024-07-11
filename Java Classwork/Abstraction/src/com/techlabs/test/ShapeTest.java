package com.techlabs.test;

import com.techlabs.model.Circle;
import com.techlabs.model.Rectangle;

public class ShapeTest {

	public static void main(String[] args) {

		Circle circle = new Circle(10);
		circle.area();

		Rectangle rectangle = new Rectangle(20, 30);
		rectangle.area();
	}

}
