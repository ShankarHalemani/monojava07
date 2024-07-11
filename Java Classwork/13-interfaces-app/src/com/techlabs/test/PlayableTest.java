package com.techlabs.test;

import java.util.Scanner;

import com.techlabs.model.Audio;
import com.techlabs.model.Playable;
import com.techlabs.model.Video;

public class PlayableTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String title;
		int resolution;

		System.out.println("Enter the song to be played\n");
		title = scanner.nextLine();
		System.out.println();

		Playable playable;

		playable = new Audio(title);
		playable.play();
		System.out.println();
		playable.pause();
		System.out.println();
		playable.stop();

		System.out.println("\nEnter video to be played");
		title = scanner.nextLine();
		System.out.println();
		System.out.println("Enter the resolution the video to be played");
		resolution = scanner.nextInt();
		System.out.println();

		playable = new Video(title, resolution);
		playable.play();
		System.out.println();
		playable.pause();
		System.out.println();
		playable.stop();

		scanner.close();

	}

}
