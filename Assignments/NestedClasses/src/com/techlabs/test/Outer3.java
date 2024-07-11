package com.techlabs.test;

public class Outer3 {
	void method1() {
		class Inner {

		}

		class Inner2 extends Inner {

		}
	}

	void method2() {
		class Inner {

		}
	}
}

// Outer class : public, default, final , abstract, strictfp, 
//Inner class : public, default, final , abstract, strictfp, static , private protected
