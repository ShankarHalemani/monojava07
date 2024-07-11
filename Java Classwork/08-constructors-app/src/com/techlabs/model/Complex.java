package com.techlabs.model;

public class Complex {
	private int imaginary;
	private int real;

	public Complex() {
		this(1, 1);
	}

	public Complex(int imaginary, int real) {
		this.imaginary = imaginary;
		this.real = real;
	}

	public void setImaginary(int imaginary) {
		this.imaginary = imaginary;
	}

	public int getImaginary() {
		return imaginary;
	}

	public void setReal(int real) {
		this.real = real;
	}

	public int getReal() {
		return real;
	}

	public void getAddition(Complex object1, Complex object2) {
		this.imaginary = object1.imaginary + object2.imaginary;
		this.real = object1.real + object2.real;
	}
}
