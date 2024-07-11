package com.techlabs.test;

import com.techlabs.model.Complex;

public class ComplexTest {

	public static void main(String[] args) {
		Complex complex1 = new Complex(4, 6);
		System.out.println("Complex number 1 : " + complex1.getReal() + " + " + complex1.getImaginary() + "i");
		System.out.println();

		Complex complex2 = new Complex(2, 3);
		System.out.println("Complex number 2 : " + complex2.getReal() + " + " + complex2.getImaginary() + "i");
		System.out.println();

		Complex complex3 = new Complex();
		complex3.getAddition(complex1, complex2);
		System.out.println("Addition of complex numbers");
		System.out.println();
		System.out.println("Complex number 3 : " + complex3.getReal() + " + " + complex3.getImaginary() + "i");

	}

}
