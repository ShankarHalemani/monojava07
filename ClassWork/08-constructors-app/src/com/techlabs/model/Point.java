package com.techlabs.model;

public class Point {
	private int x;
	private int y;

	public Point() {
		x = 0;
		y = 0;
	}

	public Point(Point point) {
		x = point.getX();
		y = point.getY();
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setX(int xi) {
		x = xi;
	}

	public int getX() {
		return x;
	}

	public void setY(int yi) {
		y = yi;
	}

	public int getY() {
		return y;
	}
}
