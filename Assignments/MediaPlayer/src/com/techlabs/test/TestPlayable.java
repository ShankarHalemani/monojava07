package com.techlabs.test;

import java.util.Scanner;

import com.techlabs.model.Audio;
import com.techlabs.model.Playable;
import com.techlabs.model.Video;

public class TestPlayable {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String title;
		int resolution;

		System.out.println("Enter the song to be played\n");
		title = scanner.nextLine();
		System.out.println();

		Playable audio = new Audio(title);
		audio.play();
		System.out.println();
		audio.pause();
		System.out.println();
		audio.stop();

		System.out.println("\nEnter video to be played");
		title = scanner.nextLine();
		System.out.println();
		System.out.println("Enter the resolution the video to be played");
		resolution = scanner.nextInt();
		System.out.println();

		Playable video = new Video(title, resolution);
		video.play();
		System.out.println();
		video.pause();
		System.out.println();
		video.stop();

		scanner.close();

	}

}
