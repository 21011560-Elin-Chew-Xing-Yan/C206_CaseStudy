public class User {
	public User(String username, String password, String role, String email) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.email = email;
	}

	private String username;
	private String password;
	private String role;
	private String email;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public String getEmail() {
		return email;
	}
}