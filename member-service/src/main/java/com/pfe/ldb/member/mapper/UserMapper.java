package com.pfe.ldb.member.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.pfe.ldb.core.protogest.user.User;
import com.pfe.ldb.entity.UserEntity;
import com.pfe.ldb.member.imapper.IUserMapper;

public class UserMapper implements IUserMapper{

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public  User convertToUserDTO(UserEntity entity) {
		User user = modelMapper.map(entity, User.class);
		return user;
	}

	@Override
	public UserEntity convertToUserEntity(User user) {
		
		UserEntity userEntity = modelMapper.map(user, UserEntity.class);
		return userEntity;
	}


}
