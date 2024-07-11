package pack2;

import pack1.A;

public class B1 extends A {

	public static void main(String[] args) {

//		We can't access protected member of parent class from child class which is in different package with parent class object
		A a = new A();
//		a.display();

//		We can access protected member of parent class from child class which is in different package with child class object
		B1 b = new B1();
		b.display();

//		We can't access protected member of parent class from child class which is in different package with parent class reference to child object
		A ab = new B1();
//		ab.display();

	}

}
