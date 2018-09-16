package sservice.student.service.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user")
public abstract class User {

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String username;
	
	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
	@Column
	private String birthday;
	
	@Column
	private String email;

	public User() {}
	
	public User(String username, String firstname, String lastname, String birthday, String email) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
