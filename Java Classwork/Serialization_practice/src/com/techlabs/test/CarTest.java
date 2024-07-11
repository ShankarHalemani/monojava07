package com.techlabs.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.techlabs.model.Car;

public class CarTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		FileOutputStream fileOutputStream;
		ObjectOutputStream objectOutputStream;

		try {
			fileOutputStream = new FileOutputStream(
					"C:\\Users\\ACER\\Documents\\MonoJava\\Serialization_practice\\serializedFile2.ser");
			objectOutputStream = new ObjectOutputStream(fileOutputStream);

			System.out.println("Enter number of cars");

			int numberOfCars = scanner.nextInt();
			System.out.println();

			Car[] cars = new Car[numberOfCars];

			for (int i = 0; i < numberOfCars; i++) {

				cars[i] = new Car();

				System.out.println("Enter vehicle company name");
				String companyName = scanner.next();
				cars[i].setCompanyName(companyName);

				System.out.println("Enter Fourwheeler mileage");
				int mileage = scanner.nextInt();
				cars[i].setMileage(mileage);

				System.out.println("Enter car price");
				int price = scanner.nextInt();
				cars[i].setPrice(price);

				System.out.println();
			}

			objectOutputStream.writeObject(cars);

			objectOutputStream.close();
			fileOutputStream.close();

		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scanner.close();
	}

}
