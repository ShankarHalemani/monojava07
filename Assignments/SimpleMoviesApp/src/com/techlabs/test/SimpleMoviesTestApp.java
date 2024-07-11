package com.techlabs.test;

import java.util.Scanner;

import com.techlabs.exceptions.CapacityFullException;
import com.techlabs.exceptions.EmptyFileException;
import com.techlabs.exceptions.MovieIDAlreadyExistsException;
import com.techlabs.exceptions.NoSuchMovieFoundException;
import com.techlabs.model.Movie;
import com.techlabs.model.SimpleMoviesApp;

public class SimpleMoviesTestApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		boolean exit = false;
		int action;
		SimpleMoviesApp simpleMoviesApp = new SimpleMoviesApp();

		while (!exit) {
			System.out.println("\nChoose");
			System.out.println("1. Add movie");
			System.out.println("2. Display all movies");
			System.out.println("3. Display particular movie");
			System.out.println("4. Remove all movies from file/ Empty the file");
			System.out.println("5. Exit");

			action = scanner.nextInt();

			switch (action) {
			case 1:
				System.out.println("Enter movie ID");
				int movieID = scanner.nextInt();
				scanner.nextLine(); // Consumes a newline

				System.out.println("Enter movie name");
				String movieName = scanner.nextLine();

				System.out.println("Enter movie genre");
				String movieGenre = scanner.next();

				System.out.println("Enter movie released year");
				int movieYear = scanner.nextInt();

				Movie movie = new Movie(movieID, movieName, movieGenre, movieYear);
				try {
					simpleMoviesApp.addMovies(movie);
				}

				catch (CapacityFullException e) {
					System.out.println(e.getMessage());
				}

				catch (MovieIDAlreadyExistsException e) {
					System.out.println(e.getMessage());
				}

				break;

			case 2:
				try {
					simpleMoviesApp.displayAllMovies();
				}

				catch (EmptyFileException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:
				try {
					simpleMoviesApp.displaySingleMovie(scanner);
				}

				catch (EmptyFileException e) {
					System.out.println(e.getMessage());
				}

				catch (NoSuchMovieFoundException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 4:
				try {
					simpleMoviesApp.clearAllMovies(scanner);
				}

				catch (EmptyFileException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 5:
				System.out.println("Exiting simple movies application");
				exit = true;
				break;

			default:
				System.out.println("Choose valid action");
				break;
			}
		}
		scanner.close();
	}

}
