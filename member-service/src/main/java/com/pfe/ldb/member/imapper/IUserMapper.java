package com.pfe.ldb.member.imapper;

import org.springframework.expression.ParseException;

import com.pfe.ldb.core.protogest.user.User;
import com.pfe.ldb.entity.UserEntity;

public interface IUserMapper {

	public User convertToUserDTO(UserEntity entity) throws ParseException;
	public UserEntity convertToUserEntity(User user) throws ParseException;
}
