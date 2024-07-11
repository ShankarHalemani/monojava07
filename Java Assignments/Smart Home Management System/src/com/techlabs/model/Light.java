package com.techlabs.model;

public class Light implements SmartDevice, Controllable {
	private String deviceID;
	private String name;
	private boolean on;

	public Light(String deviceID, String name) {
		this.deviceID = deviceID;
		this.name = name;
		this.on = false; // Light is off initially
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
			return "The light is on";
		}
		return "The light is off";
	}
}
