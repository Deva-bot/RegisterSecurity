package LoginAndRegisterProject.DtoLayer;

public class RegisterDto 
{
	private String name;
	private String userName;
	private String password;
	private String email;
	private String role;
	
	

	public RegisterDto() 
	{
		super();
		
	}

	public RegisterDto(String name, String userName, String password, String email) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public RegisterDto(String role) {
		super();
		this.role = role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
