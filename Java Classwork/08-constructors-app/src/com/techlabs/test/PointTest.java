package com.techlabs.test;

import com.techlabs.model.Point;

public class PointTest {

	public static void main(String[] args) {
		Point pt1 = new Point();
		System.out.println("Point 1 :");
		System.out.println("(" + pt1.getX() + " , " + pt1.getY() + ")");

		pt1.setX(10);
		pt1.setY(20);

		System.out.println("(" + pt1.getX() + " , " + pt1.getY() + ")");
		System.out.println();

		Point pt2 = new Point(pt1);
		System.out.println("Point 2 :");
		System.out.println("(" + pt2.getX() + " , " + pt2.getY() + ")");
		System.out.println();

		System.out.println(pt1.hashCode());
		System.out.println(pt2.hashCode());
		System.out.println();

		pt2 = pt1;
		System.out.println(pt1.hashCode());
		System.out.println(pt2.hashCode());
		System.out.println();

		Point pt3 = new Point(30, 40);
		System.out.println("Point 3 :");
		System.out.println("(" + pt3.getX() + " , " + pt3.getY() + ")");
	}

}
