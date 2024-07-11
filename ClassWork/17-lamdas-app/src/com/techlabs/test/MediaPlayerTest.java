package com.techlabs.test;

import com.techlabs.model.AudioPlayer;
import com.techlabs.model.MediaPlayer;
import com.techlabs.model.PodcastPlayer;
import com.techlabs.model.VideoPlayer;

public class MediaPlayerTest {

	public static void main(String[] args) {
		MediaPlayer mediaPlayer;

		mediaPlayer = new AudioPlayer();
		MediaPlayer.supportedFiles();
		mediaPlayer.start();
		mediaPlayer.stop();

		mediaPlayer = new VideoPlayer();
		MediaPlayer.supportedFiles();
		mediaPlayer.start();
		mediaPlayer.stop();

		mediaPlayer = new PodcastPlayer();
		MediaPlayer.supportedFiles();
		mediaPlayer.start();
		mediaPlayer.stop();

	}

}
