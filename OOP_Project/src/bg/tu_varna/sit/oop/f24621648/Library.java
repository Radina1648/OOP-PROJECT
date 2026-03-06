package bg.tu_varna.sit.oop.f24621648;

import java.util.ArrayList;
import java.util.List;

public class Library {
	public List<Book> books= new ArrayList<>();

	public void addBook(Book b){
		books.add(b);
	}

	public void removeBook(Book b){
		books.remove(b);
	}

	@Override
	public String toString() {
		return "Library{" +
				"books=" + books +
				'}';
	}
}
