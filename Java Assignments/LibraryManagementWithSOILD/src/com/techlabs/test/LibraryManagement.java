package com.techlabs.test;

import com.techlabs.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagement {

    private static List<User> users = new ArrayList<>();
    private static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("Choose");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Catalog Book");
            System.out.println("4. View Users");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7.Exit");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    addUser(scanner);
                    break;
                case 3:
                    catalogBook(scanner);
                    break;
                case 4:
                    viewUsers();
                    break;
                case 5:
                    borrowBook(scanner);
                    break;
                case 6:
                    returnBook(scanner);
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.println("Enter Book Title");
        String title = scanner.next();

        System.out.println("Enter Book Author");
        String author = scanner.next();

        System.out.println("Choose Book Type");
        System.out.println("1. EBook");
        System.out.println("2. Printed Book");
        int chooseBookType = scanner.nextInt();
        Book book;
        switch (chooseBookType) {
            case 1:
                book = new EBook(title, author, false);
                System.out.println("EBook Added");
                break;
            case 2:
                book = new PrintedBook(title, author, false);
                System.out.println("Printed Book Added");
                break;
            default:
                System.out.println("Invalid option. Book not added.");
                return;
        }
        books.add(book);
    }

    private static void addUser(Scanner scanner) {
        System.out.println("Enter Username");
        String username = scanner.next();

        System.out.println("Enter UserID");
        int userId = scanner.nextInt();

        User user = new User(username, userId);
        users.add(user);
        UserRegistration userRegistration = new UserRegistration(user);
        userRegistration.registerUser();
    }

    private static void catalogBook(Scanner scanner) {
        System.out.println("Enter Book Title");
        String title = scanner.next();
        Book book = findBookByTitle(title);
        if (book != null) {
            ICatalog catalogService = new CatalogBook();
            catalogService.catalogBook(book);
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void viewUsers() {
        for (User user : users) {
            ViewUsers viewUsers = new ViewUsers(user);
            viewUsers.viewUser();
        }
    }

    private static void borrowBook(Scanner scanner) {
        System.out.println("Enter User ID");
        int userId = scanner.nextInt();
        User user = findUserById(userId);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Enter Book Title");
        String title = scanner.next();
        Book book = findBookByTitle(title);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (book.isBorrowed()) {
            System.out.println("Book is already borrowed.");
            return;
        }

        IBorrow borrowService = new BorrowBook();
        borrowService.borrowBook(user, book);
    }

    private static void returnBook(Scanner scanner) {
        System.out.println("Enter User ID");
        int userId = scanner.nextInt();
        User user = findUserById(userId);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Enter Book Title");
        String title = scanner.next();
        Book book = findBookByTitle(title);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.isBorrowed()) {
            System.out.println("Book is not borrowed.");
            return;
        }

        IReturn returnService = new ReturnBook();
        returnService.returnBook(user, book);
    }

    private static User findUserById(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    private static Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
}