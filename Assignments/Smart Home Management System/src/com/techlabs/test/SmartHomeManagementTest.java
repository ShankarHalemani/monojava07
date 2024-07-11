package com.techlabs.test;

import java.util.Scanner;

import com.techlabs.model.Light;
import com.techlabs.model.SecurityCamera;
import com.techlabs.model.SmartDevice;
import com.techlabs.model.SmartHome;
import com.techlabs.model.Thermostat;

public class SmartHomeManagementTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the maximum number of smart devices that can be added into your smart home");
		int numberOfSmartdevices = scanner.nextInt();
		SmartHome smartHome = new SmartHome(numberOfSmartdevices);

		while (true) {
			System.out.println("\nSmart Home Management System:");
			System.out.println("1. Add Device");
			System.out.println("2. Control Device");
			System.out.println("3. List Devices");
			System.out.println("4. Exit");
			System.out.print("Choose an option: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				addDevice(scanner, smartHome);
				break;

			case 2:
				controlDevice(scanner, smartHome);
				break;

			case 3:
				smartHome.listAllDevices();
				break;

			case 4:
				System.out.println("Exiting...");
				scanner.close();
				System.exit(0);

			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}

	private static void addDevice(Scanner scanner, SmartHome smartHome) {
		System.out.println("Select Device Type to Add:");
		System.out.println("1. Light");
		System.out.println("2. Thermostat");
		System.out.println("3. Security Camera");
		System.out.print("Choose an option: ");

		int deviceType = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		System.out.println("Enter Device ID :");

		String deviceID = scanner.nextLine();

		System.out.print("Enter Device Name : ");
		String deviceName = scanner.nextLine();

		SmartDevice smartDevice = null;

		switch (deviceType) {
		case 1:
			smartDevice = new Light(deviceID, deviceName);
			break;

		case 2:
			System.out.print("Enter initial temperature for Thermostat: ");
			double temperature = scanner.nextDouble();
			scanner.nextLine(); // Consume newline
			smartDevice = new Thermostat(deviceID, deviceName, temperature);
			break;

		case 3:
			smartDevice = new SecurityCamera(deviceID, deviceName);
			break;

		default:
			System.out.println("Invalid device type. Please try again.");
			addDevice(scanner, smartHome); // Allowing the user to re-enter the device type if he chooses invalid option
			break;
		}

		smartHome.addDevice(smartDevice);

	}

	private static void controlDevice(Scanner scanner, SmartHome smartHome) {
		System.out.print("Enter Device ID to Control: ");
		String deviceID = scanner.nextLine();

		System.out.print("Enter true to turn on or false to turn off: ");
		boolean turnOn = scanner.nextBoolean();
		scanner.nextLine(); // Consume newline

		smartHome.controlDevice(deviceID, turnOn);
	}

}
