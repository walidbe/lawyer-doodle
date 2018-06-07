package com.pfe.ldb.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.pfe.ldb.member.iservice.IMemberService;

@Service
public class MemberService implements IMemberService {

	@Override
	public UserDetails loadByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetails loadByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}



}
