package com.pfe.ldb.member.iservice;

import org.springframework.security.core.userdetails.UserDetails;

public interface IMemberService {

	public UserDetails loadByEmail(String email);
	public UserDetails loadByUsername(String username);
}
