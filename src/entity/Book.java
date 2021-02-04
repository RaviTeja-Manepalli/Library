package entity;

public class Book {
	private String bookId;
	private String bookName;
	private int quantity;
	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	private String authorName;
	private String genre;

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Book(String bookId, String bookName, String authorName,int quantity, String genre) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName=authorName;
		this.quantity = quantity;
		this.genre = genre;
	}

	public Book() {

	}

}
