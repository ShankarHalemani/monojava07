//Normal inner class

package com.techlabs.test;

//Example-1
class Outer2 {
	int a = 10, b = 20;

	Outer2() {
		System.out.println("Constructor of outer");
	}

	void m1() {
		System.out.println("outer class m1()");
	}

	static {
		System.out.println("Static block inside outer");
	}

	class Inner {
		int a = 100, b = 200;
		public final static int x = 10;
//		public static int y =20;

		Inner() {
			System.out.println("Constructor of outer");
		}

		void m2() {
			System.out.println("Inner class m2() method");
			System.out.println(this.a + this.b);
			System.out.println(Outer2.this.a + Outer2.this.b);
		}

//		static {
//			System.out.println("Static block inside inner");
//		}
	}

}

class Test {
	public static void main(String[] args) {
		Outer2 o = new Outer2();
		Outer2.Inner i = o.new Inner(); // to create inner class object we need outer class object
		i.m2();
		o.m1();
	}
}

/*
 * We can use main method inside outer class
 * 
 * if we use same name variable in outer and inner class we can access inner
 * class variable with this operator and outer class variable can be access
 * using Outer.this.a;
 * 
 * We can have use Constructor in both inner and outer class
 * 
 * we can use static block inside outer class but not inner class
 * 
 * we can't have only static variables, final static variables are usable in
 * inner class
 */