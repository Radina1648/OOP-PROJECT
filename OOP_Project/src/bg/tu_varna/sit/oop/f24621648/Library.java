package bg.tu_varna.sit.oop.f24621648;

import java.util.ArrayList;
import java.util.List;

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
}