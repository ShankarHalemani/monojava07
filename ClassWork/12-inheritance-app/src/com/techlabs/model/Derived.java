package com.techlabs.model;

public class Derived extends Base {
	public int x;

	public Derived() {
		super();
	}

	public Derived(int x) {
		super(x);
		this.x = x;
	}

	public void display() {
		x++;
		System.out.println("Inside derived : x = " + x);
		System.out.println("Inside derived -> base : x = " + super.x);
		super.display();
	}

}
