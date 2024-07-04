package LoginAndRegisterProject.Model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class UserModel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	@Column(nullable = false, unique = true)
	private String userName;
	private String password;
	@Column(nullable = false,unique = true)
	private String email;
	private String role;
	
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "RoleModel",referencedColumnName = "id"))
	private Set<RoleModel> roles = new HashSet<>();

	public UserModel() 
	{
		super();
		
	}

	public UserModel(long id, String name, String userName, String password, String email, Set<RoleModel> roles) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.roles = roles;
	}
	public String getRole() 
	{
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserModel(Set<RoleModel> roles) {
		super();
		this.roles = roles;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Set<RoleModel> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleModel> roles) {
		this.roles = roles;
	}
	
	
	
}
