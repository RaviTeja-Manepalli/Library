package entity;

public class User {
	private String userId;
	private String userName;
	private String role;
	private String number;
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(String userId, String userName, String role, String number, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.role = role;
		this.number = number;
		this.password = password;
	}

	public User() {

	}

}
