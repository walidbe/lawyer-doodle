package com.pfe.ldb.member.imapper;

import org.springframework.expression.ParseException;

import com.pfe.ldb.core.protogest.user.User;
import com.pfe.ldb.core.protogest.utils.AbstractModel;
import com.pfe.ldb.entity.AbstractEntity;
import com.pfe.ldb.entity.UserEntity;

public interface IMapper {

	public AbstractModel convertToDTO(AbstractEntity entity) throws ParseException;
	public AbstractEntity convertToEntity(AbstractModel model) throws ParseException;
}
