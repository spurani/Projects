package com.mypackage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="seq_user_id", initialValue=1, allocationSize=1)
@Table(name = "t_user")
public class T_User implements IStorable{
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_user_id")
	@Id
	@Column(name="userid")
	private int userid;

	@Column(name = "username")
	private String username;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "pw")
	private String pw;
	
	@Column(name = "email")
	private String email;
	
	public T_User() {
		super();
	}

	public T_User(String username, String firstname, String lastname, String password, String email) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.pw = password;
		this.email = email;
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

	public String getPassword() {
		return pw;
	}

	public void setPassword(String password) {
		this.pw = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", password="
				+ pw + ", email=" + email + "]";
	}
	
	

}
