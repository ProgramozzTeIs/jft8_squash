package pti.sb_squash_mvc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("user")
public class User {
	
	@Id
	@Column("id")
	private Integer id;
	@Column("name")
	private String name;
	@Column("password")
	private String password;
	@Column("role")
	private String role;
	@Column("logged_in")
	private Boolean loggedIn;
	@Column("first_login_done")
	private Boolean firstLoginDone;
	
	public User(Integer id, String name, String password, String role, Boolean loggedIn, Boolean firstLoginDone) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
		this.loggedIn = loggedIn;
		this.firstLoginDone = firstLoginDone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public Boolean getFirstLoginDone() {
		return firstLoginDone;
	}

	public void setFirstLoginDone(Boolean firstLoginDone) {
		this.firstLoginDone = firstLoginDone;
	}
	
	

}
