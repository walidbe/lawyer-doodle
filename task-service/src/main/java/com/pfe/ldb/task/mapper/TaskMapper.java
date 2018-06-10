package com.pfe.ldb.task.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Component;

import com.pfe.ldb.core.protogest.task.Task;
import com.pfe.ldb.core.protogest.user.User;
import com.pfe.ldb.core.protogest.utils.AbstractModel;
import com.pfe.ldb.entity.AbstractEntity;
import com.pfe.ldb.entity.TaskEntity;
import com.pfe.ldb.entity.TaskGroupEntity;
import com.pfe.ldb.task.imapper.IMapper;
import com.pfe.ldb.task.repository.TaskGroupRepository;

@Component
public  class TaskMapper implements IMapper {

	@Autowired
	private TaskGroupRepository taskGroupRepository;
	
	@Override
	public AbstractModel convertToDTO(AbstractEntity entity) throws ParseException {
		TaskEntity taskEntity = (TaskEntity)entity;
		Task task = new Task(taskEntity.getId(), taskEntity.getName(), taskEntity.getDescription());
		return task;
	}

	@Override
	public AbstractEntity convertToEntity(AbstractModel model) throws ParseException {
		Task task = (Task)model;
		TaskGroupEntity taskGroupEntity = taskGroupRepository.findById(task.getId()).get();
		TaskEntity taskEntity = new TaskEntity(task.getName(), task.getDescription(),taskGroupEntity);
		return taskEntity;
	}

}
