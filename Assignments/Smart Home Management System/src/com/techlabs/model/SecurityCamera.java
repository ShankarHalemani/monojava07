package com.techlabs.model;

public class SecurityCamera implements SmartDevice, Monitorable {
	private String deviceID;
	private String name;
	private boolean recording;

	public SecurityCamera(String deviceID, String name) {
		this.deviceID = deviceID;
		this.name = name;
		this.recording = false; // Initially camera is not recording
	}

	public String getDeviceId() {
		return deviceID;
	}

	public String getName() {
		return name;
	}

	public boolean isOn() {
		return recording;
	}

	public String getStatus() {
		if (recording == true) {
			return "Recording is on";
		}
		return "Recording is off";
	}

	public void startRecording() {
		this.recording = true;
	}

	public void stopRecording() {
		this.recording = false;
	}
}
