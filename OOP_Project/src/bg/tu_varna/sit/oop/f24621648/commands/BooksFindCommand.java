package bg.tu_varna.sit.oop.f24621648.commands;

import bg.tu_varna.sit.oop.f24621648.main.Book;
import bg.tu_varna.sit.oop.f24621648.main.Library;

import java.util.ArrayList;
import java.util.List;

public class BooksFindCommand implements Command {

	private Library library;

	public BooksFindCommand(Library library) {
		this.library = library;
	}

	@Override
	public void execute(String input) {

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
