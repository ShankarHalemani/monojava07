package com.techlabs.model;

public class SmartHome {
	private SmartDevice[] smartDevices;
	private int actualNumberOfSmartDevices;

	public SmartHome(int maximumNumberOfSmartDevices) {
		smartDevices = new SmartDevice[maximumNumberOfSmartDevices];
		actualNumberOfSmartDevices = 0;
	}

	public void addDevice(SmartDevice smartDevice) {
		if (actualNumberOfSmartDevices < smartDevices.length) {
			smartDevices[actualNumberOfSmartDevices] = smartDevice;
			actualNumberOfSmartDevices++;
			System.out.println("Device added successfully");
			return;
		}
		System.out.println("Cannot add more devices, maximum smart devices limit reached");

	}

	public void controlDevice(String deviceID, boolean turnOn) {
		for (int i = 0; i < actualNumberOfSmartDevices; i++) {

			String tempDeviceID = smartDevices[i].getDeviceId();
			if (tempDeviceID.equals(deviceID)) {
				if (smartDevices[i] instanceof Controllable) {
					Controllable controllable = (Controllable) smartDevices[i];
					if (turnOn) {
						controllable.turnOn();
						return;
					}
					controllable.turnOff();
				}

				if (smartDevices[i] instanceof SecurityCamera) {
					SecurityCamera securityCamera = (SecurityCamera) smartDevices[i];
					if (turnOn) {
						securityCamera.startRecording();
						return;
					}
					securityCamera.stopRecording();
				}
				break;
			}
		}
		System.out.println("Device not found, Please enter valid Device ID");
	}

	public void listAllDevices() {
		int lightCount = 0, thermostatCount = 0, cameraCount = 0;
		int lightsOn = 0, thermostatOn = 0, cameraOn = 0;

		boolean anyDeviceOn = false;
		boolean anyDeviceOff = false;

		System.out.println("Devices that are ON");
		for (int i = 0; i < actualNumberOfSmartDevices; i++) {

			if (smartDevices[i].isOn() == true) {
				System.out.println("Device ID : " + smartDevices[i].getDeviceId());
				System.out.println("Device Name : " + smartDevices[i].getName());
				if (smartDevices[i] instanceof Monitorable) {
					Monitorable monitorable = (Monitorable) smartDevices[i];
					System.out.println("Device Status : " + monitorable.getStatus());
				}
				if (smartDevices[i] instanceof Light) {
					Light light = (Light) smartDevices[i];
					System.out.println("Device Status : " + light.getStatus());
				}
				System.out.println();

				if (smartDevices[i] instanceof Light) {
					lightsOn++;
					lightCount++;
				}

				if (smartDevices[i] instanceof Thermostat) {
					thermostatOn++;
					thermostatCount++;
				}

				if (smartDevices[i] instanceof SecurityCamera) {
					cameraOn++;
					cameraCount++;
				}

				anyDeviceOn = true;
			}
		}

		if (!anyDeviceOn) {
			System.out.println("No devices are currently ON");
		}
		System.out.println();

		System.out.println("Devices that are OFF");
		for (int i = 0; i < actualNumberOfSmartDevices; i++) {
			if (smartDevices[i].isOn() == false) {
				System.out.println("Device ID : " + smartDevices[i].getDeviceId());
				System.out.println("Device Name : " + smartDevices[i].getName());
				if (smartDevices[i] instanceof Monitorable) {
					Monitorable monitorable = (Monitorable) smartDevices[i];
					System.out.println("Device Status : " + monitorable.getStatus());
				}
				if (smartDevices[i] instanceof Light) {
					Light light = (Light) smartDevices[i];
					System.out.println("Device Status : " + light.getStatus());
				}
				System.out.println();

				if (smartDevices[i] instanceof Light) {

					lightCount++;
				}

				if (smartDevices[i] instanceof Thermostat) {

					thermostatCount++;
				}

				if (smartDevices[i] instanceof SecurityCamera) {

					cameraCount++;
				}

				anyDeviceOff = true;
			}
		}

		if (!anyDeviceOff) {
			System.out.println("No devices are currently OFF");
		}
		System.out.println();

		System.out.println("Total Devices : " + actualNumberOfSmartDevices);
		System.out.println();

		System.out.println("Lights ON : " + lightsOn);
		System.out.println("Thermostats ON : " + thermostatOn);
		System.out.println("Cameras ON : " + cameraOn);
		System.out.println();

		System.out.println("Lights OFF : " + (lightCount - lightsOn));
		System.out.println("Thermostats OFF : " + (thermostatCount - thermostatOn));
		System.out.println("Cameras OFF : " + (cameraCount - cameraOn));
		System.out.println();

		System.out.println("Total number of Lights : " + lightCount);
		System.out.println("Total number of Thermostats : " + thermostatCount);
		System.out.println("Total number of Cameras : " + cameraCount);
	}

}
