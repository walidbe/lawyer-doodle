package com.pfe.ldb.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pfe.ldb.entity.UserAuthoritiesEntity;
import com.pfe.ldb.entity.UserEntity;
import com.pfe.ldb.member.iservice.IUserService;
import com.pfe.ldb.member.repository.RoleRepository;
import com.pfe.ldb.member.repository.UserRepository;


public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired RoleRepository roleRepository;

	@Override
	public List<UserAuthoritiesEntity> loadByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<UserAuthoritiesEntity> loadByUsername(String username) {
		UserEntity userEntity = userRepository.findByUsername(username);
		List<UserAuthoritiesEntity> userAuthorities = null;
		if(userEntity != null) {
			userAuthorities = roleRepository.findByUserId(userEntity.getId());
		}
		return userAuthorities;
	}

}
