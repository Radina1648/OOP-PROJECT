package bg.tu_varna.sit.oop.f24621648;

public class Book {
	private String author;
	private String title;
	private String genre;
	private String description;
	private int year;
	String[] tags;
	private double rating;
	private String isbn;

	public Book(String author, String title,String genre, String description, int year, String[] tags, double rating, String isbn){
		this.author=author;
		this.title=title;
		this.genre=genre;
		this.description=description;
		this.year=year;
		this.tags=tags;
		this.rating=rating;
		this.isbn=isbn;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public String getGenre() {
		return genre;
	}

	public String getDescription() {
		return description;
	}

	public int getYear() {
		return year;
	}

	public String[] getTags() {
		return tags;
	}

	public double getRating() {
		return rating;
	}

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
