package bg.tu_varna.sit.oop.f24621648.commands;

import bg.tu_varna.sit.oop.f24621648.main.Book;
import bg.tu_varna.sit.oop.f24621648.main.Library;

import java.util.List;


public class BooksSortCommand implements Command {

    private Library library;
    private CommandManager manager;

    public BooksSortCommand(Library library,  CommandManager manager) {
        this.library = library;
        this.manager = manager;
    }

    @Override
    public void execute(String input) {
        if (manager.getCurrentFile() == null) { System.out.println("No file opened."); return; }

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