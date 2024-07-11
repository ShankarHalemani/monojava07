package com.techlabs.model;

public class Thermostat implements SmartDevice, Controllable, Monitorable {
	private String deviceID;
	private String name;
	private boolean on;
	private double temperature;

	public Thermostat(String deviceID, String name, double temperature) {
		this.deviceID = deviceID;
		this.name = name;
		this.temperature = temperature; // Initial temperature
		this.on = false; // Initially thermostat is off

	}

	public String getDeviceId() {
		return deviceID;
	}

	public String getName() {
		return name;
	}

	public boolean isOn() {
		return on;
	}

	public void turnOn() {
		this.on = true;
	}

	public void turnOff() {
		this.on = false;
	}

	public String getStatus() {
		if (on) {
			return "Thermostat is on and its temperature is " + temperature + " degree celicus";
		}
		return "Thermostat is off";

	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
}
