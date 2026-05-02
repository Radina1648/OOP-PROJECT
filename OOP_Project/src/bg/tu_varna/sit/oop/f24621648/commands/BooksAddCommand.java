package bg.tu_varna.sit.oop.f24621648.commands;

import bg.tu_varna.sit.oop.f24621648.main.Book;
import bg.tu_varna.sit.oop.f24621648.main.Library;
import bg.tu_varna.sit.oop.f24621648.main.UserManager;

import java.util.Scanner;

public class BooksAddCommand implements Command {

    private Library library;
    private UserManager userManager;
    private Scanner scanner;

    public BooksAddCommand(Library library, UserManager userManager, Scanner scanner) {
        this.library = library;
        this.userManager = userManager;
        this.scanner = scanner;
    }

    @Override
    public void execute(String input) {

        if (userManager.getLoggedUser() == null ||
                !userManager.getLoggedUser().isAdmin()) {

            System.out.println("Only admin can add books.");
            return;
        }

        System.out.print("Author: ");
        String author = scanner.nextLine();

        System.out.print("Title: ");
        String title = scanner.nextLine();

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

        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        Book book = new Book(author, title, genre, description, year, tags, rating, isbn);

        library.addBook(book);

        System.out.println("Book added successfully.");
    }
}