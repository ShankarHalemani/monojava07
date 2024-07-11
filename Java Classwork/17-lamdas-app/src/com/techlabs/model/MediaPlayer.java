package com.techlabs.model;

public interface MediaPlayer {
	void start();

	default void stop() {
		System.out.println("Media is stopped");
	}

	static void supportedFiles() {
		System.out.println("Supported files : .mp3, .mp4, .aac, .wav, .vod, .mkv");
	}
}
