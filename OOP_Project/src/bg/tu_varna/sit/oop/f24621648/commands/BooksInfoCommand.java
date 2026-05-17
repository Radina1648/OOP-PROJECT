package bg.tu_varna.sit.oop.f24621648.commands;

/**
 * Команда за показване на информация за книга.
 */

import bg.tu_varna.sit.oop.f24621648.main.Book;
import bg.tu_varna.sit.oop.f24621648.main.Library;

public class BooksInfoCommand implements Command {

	private Library library;
	private CommandManager manager;

	public BooksInfoCommand(Library library,  CommandManager manager) {
		this.library = library;
		this.manager = manager;
	}

	/**
	 * Показва информация за книга по ISBN.
	 *
	 * @param input входна команда
	 */

	@Override
	public void execute(String input) {
		if (manager.getCurrentFile() == null) { System.out.println("No file opened."); return; }

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