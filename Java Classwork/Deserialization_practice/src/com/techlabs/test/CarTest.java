package com.techlabs.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.techlabs.model.Car;

public class CarTest {

	public static void main(String[] args) {

		Car[] cars = null;

		try {
			FileInputStream fileInputStream = new FileInputStream(
					"C:\\Users\\ACER\\Documents\\MonoJava\\Serialization_practice\\serializedFile2.ser");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			cars = (Car[]) objectInputStream.readObject();
			for (Car car : cars) {

				System.out.println("Company name : " + car.getCompanyName());
				System.out.println("Fourwheeler mileage : " + car.getMileage());
				System.out.println("Car price : " + car.getPrice());

				System.out.println();
			}

			objectInputStream.close();
			fileInputStream.close();
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
