package com.pfe.ldb.task.imapper;

import org.springframework.expression.ParseException;

import com.pfe.ldb.core.protogest.utils.AbstractModel;
import com.pfe.ldb.entity.AbstractEntity;

public interface IMapper {

	public AbstractModel convertToDTO(AbstractEntity entity) throws ParseException;
	public AbstractEntity convertToEntity(AbstractModel model) throws ParseException;
}

