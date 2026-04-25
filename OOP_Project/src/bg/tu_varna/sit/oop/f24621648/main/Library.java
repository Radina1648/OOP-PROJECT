package bg.tu_varna.sit.oop.f24621648.main;

import java.util.*;

public class Library {

	private List<Book> books = new ArrayList<>();

	public void addBook(Book book){
		books.add(book);
	}

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
}