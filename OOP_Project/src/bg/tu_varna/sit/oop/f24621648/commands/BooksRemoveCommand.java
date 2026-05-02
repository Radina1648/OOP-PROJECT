package bg.tu_varna.sit.oop.f24621648.commands;

import bg.tu_varna.sit.oop.f24621648.main.Book;
import bg.tu_varna.sit.oop.f24621648.main.Library;
import bg.tu_varna.sit.oop.f24621648.main.UserManager;

public class BooksRemoveCommand implements Command {

    private Library library;
    private UserManager userManager;

    public BooksRemoveCommand(Library library, UserManager userManager) {
        this.library = library;
        this.userManager = userManager;
    }

    @Override
    public void execute(String input) {

        if (userManager.getLoggedUser() == null ||
                !userManager.getLoggedUser().isAdmin()) {

            System.out.println("Only admin can remove books.");
            return;
        }

        String[] parts = input.split(" ");

        if (parts.length < 3) {
            System.out.println("Usage: books remove <isbn>");
            return;
        }

        String isbn = parts[2];

        Book book = library.getBookByIsbn(isbn);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        library.removeBook(isbn);

        System.out.println("Book removed successfully.");
    }
}