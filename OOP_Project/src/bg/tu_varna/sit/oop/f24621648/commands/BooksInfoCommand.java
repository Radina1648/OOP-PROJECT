package bg.tu_varna.sit.oop.f24621648.commands;

import bg.tu_varna.sit.oop.f24621648.main.Book;
import bg.tu_varna.sit.oop.f24621648.main.Library;

public class BooksInfoCommand implements Command {

	private Library library;

	public BooksInfoCommand(Library library) {
		this.library = library;
	}

	@Override
	public void execute(String input) {
		String[] parts = input.split(" ");

		if (parts.length < 3) {
			System.out.println("Usage: books info <isbn>");
			return;
		}

		String isbn = parts[2];
		Book book = library.getBookByIsbn(isbn);

		if (book == null) {
			System.out.println("Book not found.");
		} else {
			System.out.println(book);
		}
	}
}