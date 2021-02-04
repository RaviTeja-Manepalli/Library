package service;

import java.util.HashSet;

import entity.Book;
import entity.User;

public interface Methods {
	public HashSet<User> addUserDetails(HashSet<User> user);

	public User validLoginDetails(String name, String password, HashSet<User> user);

	public void getAllBookDetails(HashSet<Book> book);

	public Book purchaseBookbyId(HashSet<Book> book);


	public HashSet<Book> updateBookbyQuant(HashSet<Book> book);

	public Book deleteBookDetails(HashSet<Book> book);

	public HashSet<Book> addBookDetails(HashSet<Book> book);
	
	
}
