package client;

import java.util.HashSet;
import java.util.Scanner;

import Exception.NoBookException;
import Exception.NoIDException;
import entity.Book;
import entity.User;
import service.Validations;
import service.LibraryOpeartions;
import service.LoginLogout;

public class ClientApp {
	static Scanner sc = new Scanner(System.in);
	static Validations valid = new Validations();
	static LibraryOpeartions operate = new LibraryOpeartions();
	static LoginLogout logDetails = new LoginLogout();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HashSet<User> user = new HashSet<User>();
		HashSet<Book> book = new HashSet<Book>();

		int choice = 0;

		do {
			System.out.println("1. Sign up");
			System.out.println("2. Login");
			System.out.println("3. Log table operations");
			System.out.println("4. exit");
			System.out.println("Enter ur choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				user = operate.addUserDetails(user);
				break;
			case 2:
				loginMenu(user, book);
				break;
			case 3:
				logTableOperations(user, book);
				break;
			case 4:
				System.out.println("thank you");
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
		} while (choice != 4);

	}

	private static void logTableOperations(HashSet<User> user, HashSet<Book> book) throws Exception {
		// TODO Auto-generated method stub
		int choice = 0;
		do {
			System.out.println("1. Display Log table details");
			System.out.println("2. Delete user details from log table");
			System.out.println("3. get Details by id");
			System.out.println("4. End log operations");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				logDetails.displayLogdetails();
				break;
			case 2:
				logDetails.deleteUserDetails();
				break;
			case 3:
				logDetails.getDetailsByid();
				break;
			case 4:
				System.out.println("Completed log opeartions");
				break;
			default:
				System.out.println("Invalid input");
			}

		} while (choice != 4);

	}

	private static void loginMenu(HashSet<User> user, HashSet<Book> book) throws Exception {
		// TODO Auto-generated method stub
		int choice = 0;
		System.out.println("Enter username ");
		String name = valid.validinput();
		System.out.println("ENter password");
		String password = valid.validinput();
		User u = operate.validLoginDetails(name, password, user);
		System.out.println(u.getNumber());
		if (u.getRole().equals("student")) {
			do {
				System.out.println("1. Book Details");
				System.out.println("2. purchase book");
				System.out.println("3. Log out");
				System.out.println("Enter choice");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					operate.getAllBookDetails(book);
					break;
				case 2:
					Book b = operate.purchaseBookbyId(book);
				//	addBookTable(b,u);
					if (b == null) {
						try {
							throw new NoBookException("No Book is present");
						} catch (Exception e2) {
							System.out.println(e2.getMessage());
						}
					}
					break;
				case 3:
					System.out.println("Logged out");
					logDetails.addSignoutDetails(u);
					break;
				default:
					System.out.println("Invalid input ");

				}
			} while (choice != 3);
		} else if (u.getRole().equals("faculty")) {
			do {
				System.out.println("1. Add Book ");
				System.out.println("2. Updaate book Quantity");
				System.out.println("3. Delete book by id");
				System.out.println("4. Display all book details");
				System.out.println("5. log out");
				System.out.println(" enter choice");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					book = operate.addBookDetails(book);
					break;
				case 2:
					book = operate.updateBookbyQuant(book);
					break;
				case 3:
					Book b = operate.deleteBookDetails(book);
					if (b == null)
						try {
							throw new NoBookException("No Book is deleted");
						} catch (Exception e2) {
							System.out.println(e2.getMessage());
						}
					break;
				case 4:
					operate.getAllBookDetails(book);
					break;
				case 5:
					System.out.println("logged out");
					logDetails.addSignoutDetails(u);

					break;
				default:
					System.out.println("Invalid input ");

				}

			} while (choice != 5);
		} else {
			try {
				throw new NoIDException("No Id present");
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}

		}

	}

}
