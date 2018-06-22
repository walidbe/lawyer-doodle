package com.pfe.ldb.core.protogest.user;

import java.util.List;

import com.pfe.ldb.core.protogest.utils.AbstractModel;

public class User extends AbstractModel {


	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private List<Authoritie> authorities;
	
	public User() {
		super();
		this.username = null;
		this.password = null;
		this.email = null;
		this.authorities = null;
		this.firstName = null;
		this.lastName = null;
	}
	
	public User(String username, String password, String email, List<Authoritie> authorities) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.authorities = authorities;
	}
	
	public User(String username, String password, String email, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public User(final Integer id, String username, String password, String email, List<Authoritie> authorities) {
		super(id);
		this.username = username;
		this.password = password;
		this.email = email;
		this.authorities = authorities;
	}
	
	
	public User(String username, String email, String firstName, String lastName) {
		super();
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public void setAuthorities(List<Authoritie> authorities) {
		
		this.authorities = authorities;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Authoritie> getAuthorities() {
		return authorities;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
