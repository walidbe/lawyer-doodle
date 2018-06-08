package com.pfe.ldb.core.protogest.user;

import java.util.List;

import com.pfe.ldb.core.protogest.utils.AbstractModel;

public class User extends AbstractModel {


	
	private String username;
	private String password;
	private String email;
	private List<Authoritie> authorities;
	
	public User(String username, String password, String email, List<Authoritie> authorities) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.authorities = authorities;
	}
	
	public User(final Integer id, String username, String password, String email, List<Authoritie> authorities) {
		super(id);
		this.username = username;
		this.password = password;
		this.email = email;
		this.authorities = authorities;
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

	public List<Authoritie> getAuthorities() {
		return authorities;
	}
}
