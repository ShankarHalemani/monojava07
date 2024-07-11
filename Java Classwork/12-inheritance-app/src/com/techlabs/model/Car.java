package com.techlabs.model;

public class Car extends FourWheeler {
	private int price;

	public Car() {
		super();
	}

	public Car(String companyName, double mileage, int price) {
		super(companyName, mileage);
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
