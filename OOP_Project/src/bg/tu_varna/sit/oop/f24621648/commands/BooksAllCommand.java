package bg.tu_varna.sit.oop.f24621648.commands;

import bg.tu_varna.sit.oop.f24621648.main.Book;
import bg.tu_varna.sit.oop.f24621648.main.Library;

public class BooksAllCommand implements Command {

	private Library library;

	public BooksAllCommand(Library library) {
		this.library = library;
	}

	@Override
	public void execute(String input) {

		if (!library.hasBooks()) {
			System.out.println("No books available.");
			return;
		}

		for (Book b : library.getAllBooks()) {
			System.out.println(b);
		}
	}
}