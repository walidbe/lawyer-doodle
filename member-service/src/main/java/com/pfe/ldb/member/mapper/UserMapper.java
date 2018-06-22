package com.pfe.ldb.member.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;

import com.pfe.ldb.core.protogest.user.User;
import com.pfe.ldb.core.protogest.utils.AbstractModel;
import com.pfe.ldb.entity.AbstractEntity;
import com.pfe.ldb.entity.MemberEntity;
import com.pfe.ldb.entity.UserEntity;
import com.pfe.ldb.member.imapper.IMapper;

public class UserMapper implements IMapper{

	@Autowired
	private ModelMapper modelMapper;
	


	@Override
	public AbstractModel convertToDTO(AbstractEntity entity) throws ParseException {
		UserEntity userEntity = (UserEntity)entity;
		User user = new User(userEntity.getMember().getEmail(), userEntity.getMember().getEmail(), userEntity.getMember().getFirstName(), userEntity.getMember().getLastName());
		return user;
	}



	@Override
	public AbstractEntity convertToEntity(AbstractModel model) throws ParseException {
		User user = (User)model;
		MemberEntity memberEntity = new MemberEntity(user.getFirstName(), user.getLastName(), user.getEmail());
		UserEntity userEntity = new UserEntity(memberEntity, user.getUsername(), user.getPassword());
		return userEntity;
	}


}
