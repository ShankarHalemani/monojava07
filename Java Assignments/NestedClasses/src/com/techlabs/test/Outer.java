package com.techlabs.test;

//Introduction to nested classes

/*
 * there are two types
 * static nested
 * non static nested (Inner class)
 * 
 * 
 */

public class Outer {
	int a;
	int b;

	void m1() {
//		c; //Outer class methods can't access inner class data members
//		m2();
	}

	class Inner {
		int c;
		int d;

		void m2() {
			c = a; // Inner class methods can access outer class data members
			m1();
		}
	}

	public static void main(String[] args) {
		Outer o = new Outer();
		Outer.Inner i = o.new Inner(); // to create inner class object we need outer class object
	}
}

/*
 * 3 types of inner classes normal inner class method local inner class
 * anonymous inner class
 * 
 */
