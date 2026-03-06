package bg.tu_varna.sit.oop.f24621648;

public class Book {
	private String author;
	private String title;
	private String genre;
	private String description;
	private int year;
	private String keyWords;
	private double rating;
	private int uniqueNumber;

	public Book(String author, String title,String genre, String description, int year, String keyWords, double rating, int uniqueNumber){
		this.author=author;
		this.title=title;
		this.genre=genre;
		this.description=description;
		this.year=year;
		this.keyWords=keyWords;
		this.rating=rating;
		this.uniqueNumber=uniqueNumber;
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

	public String getKeyWords() {
		return keyWords;
	}

	public double getRating() {
		return rating;
	}

	public int getUniqueNumber() {
		return uniqueNumber;
	}
}
