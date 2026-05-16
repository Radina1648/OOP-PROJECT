package bg.tu_varna.sit.oop.f24621648.commands;

/**
 * Команда за показване на всички книги.
 */

import bg.tu_varna.sit.oop.f24621648.main.Book;
import bg.tu_varna.sit.oop.f24621648.main.Library;

public class BooksAllCommand implements Command {

	private Library library;
	private CommandManager manager;

	public BooksAllCommand(Library library,  CommandManager manager) {
		this.library = library;
		this.manager = manager;
	}

	@Override
	public void execute(String input) {
		if (manager.getCurrentFile() == null) { System.out.println("No file opened."); return; }

		if (!library.hasBooks()) {
			System.out.println("No books available.");
			return;
		}

		for (Book b : library.getAllBooks()) {
			System.out.println(b);
		}
	}
}