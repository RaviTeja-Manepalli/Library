package service;

import entity.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import entity.Book;
import entity.User;
public class LoginLogout {
	static Scanner sc = new Scanner(System.in);
	static Validations valid = new Validations();
    public void addBookTable(Book b, User u) throws Exception
    {
		Connection con = createJDBC();
		String sql = "INSERT INTO Log (UserId, UserRole,bookname,bookQuant) VALUES (?,?,?,?)";
		String sql2 ="Select bookQuant from Book where UserId = u.getId";
		
		PreparedStatement preparedStatement = con.prepareStatement(sql);

		preparedStatement.setString(1, u.getUserId());
		preparedStatement.setString(2, u.getRole());
		preparedStatement.setString(3, b.getBookName());
		//preparedStatement.setString(4,  );



    }
	public void addSignoutDetails(User user) throws Exception {
		/*
		 * File file = new File(""); FileWriter fw = new FileWriter(file); PrintWriter
		 * pw = new PrintWriter(fw);
		 */
		Connection con = createJDBC();
		File file = new File("C:\\Java Text files\\file.txt");
		FileWriter fr = new FileWriter(file, true);
		BufferedWriter br = new BufferedWriter(fr);
		PrintWriter pr = new PrintWriter(br);

		String pattern = "MM/dd/yyyy HH:mm:ss";
		DateFormat df = new SimpleDateFormat(pattern);
		java.util.Date today = Calendar.getInstance().getTime();
		String todayAsString = df.format(today);
		System.out.println(user.getUserId() + " " + todayAsString);

		String sql = "INSERT INTO Log (UserId, UserRole,UserName,dateTimed) VALUES (?,?,?,?)";

		String insert = user.getUserId() + " " + user.getRole() + " " + user.getNumber() + " " + todayAsString;
		pr.println(insert);
		pr.close();
		br.close();
		fr.close();
		PreparedStatement preparedStatement = con.prepareStatement(sql);

		preparedStatement.setString(1, user.getUserId());
		preparedStatement.setString(2, user.getRole());
		preparedStatement.setString(3, user.getNumber());
		preparedStatement.setString(4, todayAsString);

		preparedStatement.executeUpdate();

		con.close();
		preparedStatement.close();

	}

	private Connection createJDBC() throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/org", "root", "12345678");
		return con;
	}

	public void displayLogdetails() throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;
		try {
			con = createJDBC();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			smt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "SELECT * FROM Log";
		try {
			rs = smt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (rs.next()) {
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));

		}
        rs.close();
        con.close();
        smt.close();

	}

	public void deleteUserDetails() throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement smt = null;
		con = createJDBC();
		System.out.println("Enter Id details to delete");
		String id = valid.validinput();
		String SQL = "DELETE FROM Log WHERE UserId = ? ";
		smt = con.prepareStatement(SQL);
		smt.setString(1, id);
		smt.executeUpdate();
		smt.close();
		con.close();

	}

	public void getDetailsByid() throws Exception {
		// TODO Auto-generated method stub
		Connection con = createJDBC();
		PreparedStatement smt = null;
		String id = valid.validinput();
		String SQL = "SELECT * FROM Log WHERE UserId = ? ";
		smt = con.prepareStatement(SQL);
		smt.setString(1, id);
		ResultSet rs = smt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));

		}
        rs.close();
		smt.close();
		con.close();

	}

}
