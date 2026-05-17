package bg.tu_varna.sit.oop.f24621648.commands;

/**
 * Команда за търсене на книги.
 */

import bg.tu_varna.sit.oop.f24621648.main.Book;
import bg.tu_varna.sit.oop.f24621648.main.Library;

import java.util.ArrayList;
import java.util.List;

public class BooksFindCommand implements Command {

	private Library library;
	private CommandManager manager;

	public BooksFindCommand(Library library, CommandManager manager) {
		this.library = library;
		this.manager = manager;
	}

	/**
	 * Търси книги по зададен критерий.
	 *
	 * @param input входна команда
	 */

	@Override
	public void execute(String input) {
		if (manager.getCurrentFile() == null) { System.out.println("No file opened."); return; }

		String[] parts = input.split(" ", 3);

		if (parts.length < 3) {
			System.out.println("Usage: books find <option> <value>");
			return;
		}

		String option = parts[2].split(" ")[0];
		String value = parts[2].substring(option.length()).trim();

		List<Book> result = new ArrayList<>();

		switch (option) {
			case "title":
				result = library.findByTitle(value);
				break;
			case "author":
				result = library.findByAuthor(value);
				break;
			case "tag":
				result = library.findByTag(value);
				break;
			default:
				System.out.println("Invalid option.");
				return;
		}

		if (result.isEmpty()) {
			System.out.println("No matches found.");
		} else {
			for (Book b : result) {
				System.out.println(b);
			}
		}
	}
}
