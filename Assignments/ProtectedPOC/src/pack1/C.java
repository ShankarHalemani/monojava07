package pack1;

public class C {

	public static void main(String[] args) {
//		Here we can access protected member in other class using object of that class in same package
		A a = new A();
		a.display();

//		Here we cannot access because that method is not present on C class
		C c = new C();
//		c.display();
	}

}
