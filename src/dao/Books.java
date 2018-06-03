
package dao;

public class Books {
	private int book_id;
	private String book_name;
	private String author;
	private String genre;
	
	private int year;
	private String language;
	private int price;
	private int quantity;
	public Books() {
		super();
	}

	
	public Books(int book_id, String book_name, String author, String genre, int year, String language, int price, int quantity) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.author = author;
		this.genre = genre;
		this.year = year;
		this.language = language;
		this.price = price;
		this.quantity = quantity;
		
	}
	public int getBook_id() {
		return book_id;
	}


	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	


	public String getBook_name() {
		return book_name;
	}


	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}