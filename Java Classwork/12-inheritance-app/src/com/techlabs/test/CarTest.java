package com.techlabs.test;

import java.util.Scanner;

import com.techlabs.model.Car;

public class CarTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number of cars");

		int numberOfCars = scanner.nextInt();
		System.out.println();

		Car[] cars = new Car[numberOfCars];

		for (int i = 0; i < numberOfCars; i++) {

			System.out.println("Enter vehicle company name");
			String companyName = scanner.next();

			System.out.println("Enter Fourwheeler mileage");
			double mileage = scanner.nextInt();

			System.out.println("Enter car price");
			int price = scanner.nextInt();

			cars[i] = new Car(companyName, mileage, price);

			System.out.println();
		}

		System.out.println();

		for (Car car : cars) {
			System.out.println("Company name : " + car.getCompanyName());
			System.out.println("Fourwheeler mileage : " + car.getMileage());
			System.out.println("Car price : " + car.getPrice());

			System.out.println();
		}

		scanner.close();
	}

}
