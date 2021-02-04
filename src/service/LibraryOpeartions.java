package service;

import java.util.HashSet;

import entity.Book;
import entity.User;

public class LibraryOpeartions implements Methods {
	static Validations valid = new Validations();

	@Override
	public HashSet<User> addUserDetails(HashSet<User> user) {
		// TODO Auto-generated method stub
		System.out.println("Enter ID");
		String id = valid.validinput();
		System.out.println("Enter name");
		String name = valid.validinput();
		System.out.println("Enter role");
		String role = valid.validinput();
		System.out.println("Enter Mobileno");
		String mobileno = valid.mobileValidation();
		System.out.println("Enter password");
		String password = valid.validinput();

		User u = new User(id, name, role, mobileno, password);
		user.add(u);

		return user;
	}

	@Override
	public User validLoginDetails(String name, String password, HashSet<User> user) {
		// TODO Auto-generated method stub
		for (User u : user) {
			if (u.getPassword().equals(password) && u.getUserName().equals(name)) {
				return u;
			}
		}

		return null;
	}

	@Override
	public void getAllBookDetails(HashSet<Book> book) {
		// TODO Auto-generated method stub
		for (Book b : book) {
			System.out.println(b.getBookId() + " " + b.getBookName() + " " + b.getGenre() + " " + b.getQuantity());
		}
	}

	@Override
	public Book purchaseBookbyId(HashSet<Book> book) {
		// TODO Auto-generated method stub
		System.out.println("Enter Book Id to purchase");
		String id = valid.validinput();
		for (Book b : book) {
			if (b.getBookId().compareTo(id) == 0) {
				if (b.getQuantity() >= 1) {
					b.setQuantity(b.getQuantity() - 1);
					System.out.println(
							b.getBookId() + " " + b.getBookName() + " " + b.getGenre() + " " + b.getQuantity());
					return b;
				} 

			}
		}

		return null;
	}


	@Override
	public HashSet<Book> updateBookbyQuant(HashSet<Book> book) {
		// TODO Auto-generated method stub
		System.out.println("Enter String");
		String id = valid.validinput();
		for (Book b : book) {
			if (b.getBookId().compareTo(id) == 0) {
				System.out.println("Enter quantity");
				int quant = valid.integerValidation();
				b.setQuantity(quant);
				break;
			}
		}

		return book;
	}

	@Override
	public Book deleteBookDetails(HashSet<Book> book) {
		// TODO Auto-generated method stub
		System.out.println("Enter Id");
		String id = valid.validinput();
		for (Book b : book) {
			if (b.getBookId().compareTo(id) == 0) {
				book.remove(b);
				return b;
			}
		}

		return null;
	}

	@Override
	public HashSet<Book> addBookDetails(HashSet<Book> book) {
		// TODO Auto-generated method stub
		System.out.println("Enter book ID");
		String bookId = valid.validinput();
		System.out.println("Enter book name");
		String bookName = valid.validinput();
		System.out.println(" enter authorName");
		String authorName = valid.validinput();
		System.out.println("Enter quantity");
		int quantity = valid.integerValidation();
		System.out.println("Enter Genre");
		String genre = valid.validinput();
		Book b = new Book(bookId, bookName, authorName, quantity, genre);
		book.add(b);
		return book;
	}

}
