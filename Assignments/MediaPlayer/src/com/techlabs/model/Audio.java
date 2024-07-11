package com.techlabs.model;

public class Audio extends Playable {
	private String title;

	public Audio() {
		super();
	}

	public Audio(String title) {
		this.title = title;
	}

	public void play() {
		System.out.println("The song " + title + " is playing");
	}

	public void pause() {
		System.out.println("The song " + title + " is paused");
	}

	public void stop() {
		System.out.println("The song " + title + " is stopped");
	}
}
