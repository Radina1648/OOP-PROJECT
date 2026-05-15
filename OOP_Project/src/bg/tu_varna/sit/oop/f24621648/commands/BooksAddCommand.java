package bg.tu_varna.sit.oop.f24621648.commands;

import bg.tu_varna.sit.oop.f24621648.main.Book;
import bg.tu_varna.sit.oop.f24621648.main.Library;
import bg.tu_varna.sit.oop.f24621648.main.UserManager;

import java.util.Scanner;

public class BooksAddCommand implements Command {

    private Library library;
    private UserManager userManager;
    private Scanner scanner;
    private CommandManager manager;

    public BooksAddCommand(Library library, UserManager userManager, Scanner scanner, CommandManager manager) {
        this.library = library;
        this.userManager = userManager;
        this.scanner = scanner;
        this.manager = manager;
    }

    @Override
    public void execute(String input) {

        if (manager.getCurrentFile() == null) {
            System.out.println("No file opened.");
            return;
        }

        if (userManager.getLoggedUser() == null ||
                !userManager.getLoggedUser().isAdmin()) {

            System.out.println("Only admin can add books.");
            return;
        }

        System.out.print("Author: ");
        String author = scanner.nextLine();

        System.out.print("Title: ");
        String title = scanner.nextLine();

        if (title.isBlank()) {
            System.out.println("Title cannot be empty.");
            return;
        }

        System.out.print("Genre: ");
        String genre = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Year: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("Tags (comma separated): ");
        String[] tags = scanner.nextLine().split(",");

        System.out.print("Rating: ");
        double rating = Double.parseDouble(scanner.nextLine());

        if (rating < 0 || rating > 5) {
            System.out.println("Rating must be between 0 and 5.");
            return;
        }

        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        if (library.getBookByIsbn(isbn) != null) {
            System.out.println("Book already exists.");
            return;
        }

        Book book = new Book(author, title, genre, description, year, tags, rating, isbn);

        library.addBook(book);

        System.out.println("Book added successfully.");
    }
}