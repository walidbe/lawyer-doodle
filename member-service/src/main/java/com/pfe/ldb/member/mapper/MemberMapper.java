package com.pfe.ldb.member.mapper;

import org.springframework.expression.ParseException;

import com.pfe.ldb.core.protogest.user.User;
import com.pfe.ldb.core.protogest.utils.AbstractModel;
import com.pfe.ldb.entity.AbstractEntity;
import com.pfe.ldb.entity.MemberEntity;
import com.pfe.ldb.entity.UserEntity;
import com.pfe.ldb.member.imapper.IMapper;

public class MemberMapper implements IMapper {

	@Override
	public User convertToDTO(AbstractEntity entity) throws ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberEntity convertToEntity(AbstractModel model) throws ParseException {
		User user = (User)model;
		MemberEntity memberEntity = new MemberEntity(user.getFirstName(), user.getLastName(), user.getEmail());
		return memberEntity;
	}

}
