package com.techlabs.model;

public class Video extends Playable {

	private String title;
	private int resolution;

	public Video() {
		super();
	}

	public Video(String title, int resolution) {

		this.title = title;
		this.resolution = resolution;
	}

	public void play() {
		System.out.println("The video " + title + " is playing in " + resolution + "p resolution");
	}

	public void pause() {
		System.out.println("The video " + title + " was playing in " + resolution + "p resolution is paused");
	}

	public void stop() {
		System.out.println("The video " + title + " was playing in " + resolution + "p resolution is stopped");
	}
}
