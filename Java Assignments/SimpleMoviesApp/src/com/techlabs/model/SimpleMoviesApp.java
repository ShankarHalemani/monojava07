package com.techlabs.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.techlabs.exceptions.CapacityFullException;
import com.techlabs.exceptions.EmptyFileException;
import com.techlabs.exceptions.MovieIDAlreadyExistsException;
import com.techlabs.exceptions.NoSuchMovieFoundException;

public class SimpleMoviesApp {
	private Movie[] simpleMovies;
	private int numberOfMovies;
	private int[] usedMovieID;

	private static final String FILE_PATH = "C:\\Users\\ACER\\Documents\\MonoJava\\Assignments\\SimpleMoviesApp\\Movies.ser";

	public SimpleMoviesApp() {
		simpleMovies = new Movie[5];
		numberOfMovies = 0;
		usedMovieID = new int[5];
		loadMovies();

	}

	// Serialization
	private void saveMovies() {
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(FILE_PATH);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(simpleMovies);

			objectOutputStream.close();
			fileOutputStream.close();

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Deserialization
	private void loadMovies() {
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(FILE_PATH);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			simpleMovies = (Movie[]) objectInputStream.readObject();

			numberOfMovies = 0;
			for (Movie movie : simpleMovies) {
				if (movie != null) {
					usedMovieID[numberOfMovies] = movie.getMovieID();
					numberOfMovies++;
				}
			}

			objectInputStream.close();
			fileInputStream.close();

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private boolean isUsedMovieID(int movieID) {
		for (int i = 0; i < numberOfMovies; i++) {
			if (usedMovieID[i] == movieID) {
				return true;
			}
		}
		return false;
	}

	public void addMovies(Movie movie) throws CapacityFullException, MovieIDAlreadyExistsException {
		if (numberOfMovies >= 5) {
			throw new CapacityFullException();
		}

		if (isUsedMovieID(movie.getMovieID())) {
			throw new MovieIDAlreadyExistsException();
		}

		if (numberOfMovies < 5) {
			simpleMovies[numberOfMovies] = movie;
			usedMovieID[numberOfMovies] = movie.getMovieID();
			numberOfMovies++;
			saveMovies();
			System.out.println("Movie is added");
			System.out.println("There are " + numberOfMovies + " movies in total as of now");
		}

	}

	public void displayAllMovies() throws EmptyFileException {

		loadMovies();
		if (numberOfMovies == 0) {
			throw new EmptyFileException();
		}
		for (Movie movie : simpleMovies) {
			if (movie != null) {
				System.out.println("\nMovie ID : " + movie.getMovieID());
				System.out.println("Movie Name : " + movie.getMovieName());
				System.out.println("Movie genre : " + movie.getGenre());
				System.out.println("Year released : " + movie.getMovieYear());
			}
		}

	}

	public void displaySingleMovie(Scanner scanner) throws EmptyFileException, NoSuchMovieFoundException {

		loadMovies();
		if (numberOfMovies == 0) {
			throw new EmptyFileException();
		}
		System.out.println("Enter movie ID to search");
		int movieId = scanner.nextInt();

		for (Movie movie : simpleMovies) {
			if (movie != null && movie.getMovieID() == movieId) {
				System.out.println("Movie ID : " + movie.getMovieID());
				System.out.println("Movie Name : " + movie.getMovieName());
				System.out.println("Movie genre : " + movie.getGenre());
				System.out.println("Year released : " + movie.getMovieYear());
				System.out.println();
				return;
			}
		}
		throw new NoSuchMovieFoundException();
	}

	public void clearAllMovies(Scanner scanner) throws EmptyFileException {
		if (numberOfMovies == 0) {
			throw new EmptyFileException();
		}
		System.out.println("Remove all movies from file ? (yes/no)");
		String removeMovies = scanner.next();
		if (removeMovies.equalsIgnoreCase("yes")) {
			simpleMovies = new Movie[5];
			numberOfMovies = 0;
			saveMovies();
			System.out.println("Removed All existing movies from file");
			return;
		}
		System.out.println("Movies are not removed");
	}

}
