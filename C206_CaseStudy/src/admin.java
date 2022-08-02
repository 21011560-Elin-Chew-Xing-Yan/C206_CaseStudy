
public class admin extends User {
	public admin(String username, String password, String email, String role) {
		super(username, password, email);
		this.role = role;
	}

	private String role;

	public String getRole() {
		return role;
	}

}
