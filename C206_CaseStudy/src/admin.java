
public class admin extends User {
	private String role;

	public admin(String username, String password, String email, String role) {
		super(username, password, email);
		this.role = "Admin";
	}

	public String getRole() {
		return role;
	}
	

}
