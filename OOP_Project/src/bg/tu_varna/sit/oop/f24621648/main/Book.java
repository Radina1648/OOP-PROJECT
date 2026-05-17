package bg.tu_varna.sit.oop.f24621648.main;

/**
 * Клас, описващ книга в библиотеката.
 */

public class Book {
	private String author;
	private String title;
	private String genre;
	private String description;
	private int year;
	String[] tags;
	private double rating;
	private String isbn;

	/**
	 * Създава нова книга.
	 *
	 * @param author автор на книгата
	 * @param title заглавие на книгата
	 * @param genre жанр на книгата
	 * @param description описание на книгата
	 * @param year година на издаване
	 * @param tags ключови думи
	 * @param rating рейтинг на книгата
	 * @param isbn уникален номер на книгата
	 */

	public Book(String author, String title,String genre, String description, int year, String[] tags, double rating, String isbn){
		this.author=author;
		this.title=title;
		this.genre=genre;
		this.description=description;
		this.year=year;
		this.tags=tags;
		this.rating=rating;
		this.isbn = isbn;
	}

	/**
	 * Връща автора на книгата.
	 *
	 * @return автор на книгата
	 */

	public String getAuthor() {
		return author;
	}

	/**
	 * Връща заглавието на книгата.
	 *
	 * @return заглавие на книгата
	 */

	public String getTitle() {
		return title;
	}

	/**
	 * Връща жанра на книгата.
	 *
	 * @return жанр на книгата
	 */

	public String getGenre() {
		return genre;
	}

	/**
	 * Връща описанието на книгата.
	 *
	 * @return описание на книгата
	 */

	public String getDescription() {
		return description;
	}

	/**
	 * Връща годината на издаване.
	 *
	 * @return година на издаване
	 */

	public int getYear() {
		return year;
	}

	/**
	 * Връща таговете на книгата.
	 *
	 * @return масив с тагове
	 */

	public String[] getTags() {
		return tags;
	}

	/**
	 * Връща рейтинга на книгата.
	 *
	 * @return рейтинг на книгата
	 */

	public double getRating() {
		return rating;
	}

	/**
	 * Връща ISBN номера.
	 *
	 * @return ISBN номер
	 */

	public String getIsbn() {
		return isbn;
	}

	@Override
	public String toString() {
		return "Title: " + title +
				", Author: " + author +
				", Genre: " + genre +
				", Year: " + year +
				", Rating: " + rating +
				", ISBN: " + isbn;
	}
}
