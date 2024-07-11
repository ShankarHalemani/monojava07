package pack1;

public class B extends A {
	public static void main(String[] args) {

//		Here we proving that within same package we can access protected members in subclass
		A a = new A();
		a.display();

		B b = new B();
		b.display();

		A ab = new B();
		ab.display();
	}
}
