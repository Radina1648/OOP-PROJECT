package bg.tu_varna.sit.oop.f24621648.main;

/**
 * Клас за управление на библиотеката.
 */

import java.io.*;
import java.util.*;

public class Library {

	private List<Book> books = new ArrayList<>();

	/**
	 * Добавя книга в библиотеката.
	 */

	public void addBook(Book book){
		books.add(book);
	}

/**
 * Премахва книга по ISBN.
 */

	public void removeBook(String isbn){

		Book toRemove = null;

		for(Book b : books){
			if(b.getIsbn().equals(isbn)){
				toRemove = b;
				break;
			}
		}

		if(toRemove != null){
			books.remove(toRemove);
		}
	}

	public List<Book> getAllBooks(){
		return books;
	}

	/**
	 * Търси книга по ISBN.
	 */

	public Book getBookByIsbn(String isbn){

		for(Book b : books){
			if(b.getIsbn().equals(isbn)){
				return b;
			}
		}

		return null;
	}

	public boolean hasBooks() {
		return !books.isEmpty();
	}

	public List<Book> findByTitle(String title){

		List<Book> result = new ArrayList<>();

		for(Book b : books){
			if(b.getTitle().toLowerCase().contains(title.toLowerCase())){
				result.add(b);
			}
		}

		return result;
	}

	public List<Book> findByAuthor(String author){

		List<Book> result = new ArrayList<>();

		for(Book b : books){
			if(b.getAuthor().toLowerCase().contains(author.toLowerCase())){
				result.add(b);
			}
		}

		return result;
	}

	public List<Book> findByTag(String tag){

		List<Book> result = new ArrayList<>();

		for(Book b : books){

			String[] tags = b.getTags();

			for(int i = 0; i < tags.length; i++){
				if(tags[i].equalsIgnoreCase(tag)){
					result.add(b);
					break;
				}
			}
		}

		return result;
	}

	public List<Book> sortBooks(String option, String order) {

		List<Book> sortedBooks = new ArrayList<>(books);

		Map<String, Comparator<Book>> sortOptions = new HashMap<>();

		sortOptions.put("title",
				Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));

		sortOptions.put("author",
				Comparator.comparing(Book::getAuthor, String.CASE_INSENSITIVE_ORDER));

		sortOptions.put("year",
				Comparator.comparingInt(Book::getYear));

		sortOptions.put("rating",
				Comparator.comparingDouble(Book::getRating));

		Comparator<Book> comparator = sortOptions.get(option.toLowerCase());

		if (comparator == null) {
			return sortedBooks;
		}

		if (order.equalsIgnoreCase("desc")) {
			comparator = comparator.reversed();
		}

		sortedBooks.sort(comparator);

		return sortedBooks;
	}

	public void clear() {
		books.clear();
	}

	/**
	 * Зарежда книги от файл.
	 */

	public void loadFromFile(String fileName) {

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

			books.clear();

			String line;

			while ((line = reader.readLine()) != null) {

				String[] parts = line.split(";");

				String author = parts[0];
				String title = parts[1];
				String genre = parts[2];
				String description = parts[3];
				int year = Integer.parseInt(parts[4]);
				String[] tags = parts[5].split(",");
				double rating = Double.parseDouble(parts[6]);
				String isbn = parts[7];

				Book book = new Book(author, title, genre, description, year, tags, rating, isbn);

				books.add(book);
			}

		} catch (IOException e) {
			System.out.println("Error reading file.");
		}
	}

/**
 * Записва книги във файл.
 */

	public void saveToFile(String fileName) {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

			for (Book b : books) {

				String line =
						b.getAuthor() + ";" +
								b.getTitle() + ";" +
								b.getGenre() + ";" +
								b.getDescription() + ";" +
								b.getYear() + ";" +
								String.join(",", b.getTags()) + ";" +
								b.getRating() + ";" +
								b.getIsbn();

				writer.write(line);
				writer.newLine();
			}

		} catch (IOException e) {
			System.out.println("Error writing to file.");
		}
	}
}