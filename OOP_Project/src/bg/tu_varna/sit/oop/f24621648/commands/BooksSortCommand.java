package bg.tu_varna.sit.oop.f24621648.commands;

import bg.tu_varna.sit.oop.f24621648.main.Book;
import bg.tu_varna.sit.oop.f24621648.main.Library;

import java.util.List;


public class BooksSortCommand implements Command {

    private Library library;

    public BooksSortCommand(Library library) {
        this.library = library;
    }

    @Override
    public void execute(String input) {

        String[] parts = input.split(" ");

        if (parts.length < 3) {
            System.out.println("Usage: books sort <option> [asc|desc]");
            return;
        }

        String option = parts[2];
        String order = "asc";

        if (parts.length > 3) {
            order = parts[3];
        }

        List<Book> result = library.sortBooks(option, order);

        for (Book book : result) {
            System.out.println(book);
        }
    }
}