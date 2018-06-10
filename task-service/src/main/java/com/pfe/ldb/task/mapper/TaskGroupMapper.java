package com.pfe.ldb.task.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Component;

import com.pfe.ldb.core.protogest.task.Group;
import com.pfe.ldb.core.protogest.task.Task;
import com.pfe.ldb.core.protogest.task.TaskGroup;
import com.pfe.ldb.core.protogest.utils.AbstractModel;
import com.pfe.ldb.entity.AbstractEntity;
import com.pfe.ldb.entity.TaskEntity;
import com.pfe.ldb.entity.TaskGroupEntity;
import com.pfe.ldb.task.imapper.IMapper;
import com.pfe.ldb.task.repository.TaskGroupRepository;
import com.pfe.ldb.task.repository.TaskRepository;

@Component
public class TaskGroupMapper implements IMapper {

	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private TaskGroupRepository taskGroupRepository;

	private final static IMapper taskMapper = new TaskMapper();

	@Override
	public AbstractModel convertToDTO(AbstractEntity entity) throws ParseException {
		TaskGroupEntity taskGroupEntity = (TaskGroupEntity) entity;
		List<TaskEntity> tasksEntity = taskRepository.findByTaskGroupId(taskGroupEntity.getId());
		List<Task> tasks = new ArrayList<>();
		for (TaskEntity taskEntity : tasksEntity) {
			tasks.add((Task) taskMapper.convertToDTO(taskEntity));
		}
		Group parent = null;
		if (taskGroupEntity.getParent() != null) {
			parent = new Group(taskGroupEntity.getParent().getId(), taskGroupEntity.getParent().getName(),
					taskGroupEntity.getParent().getDescription());
		}
		List<Group> childTaskGroup = new ArrayList<>();
		for(TaskGroupEntity childTaskGroupEntity : taskGroupRepository.findAllByParentId(taskGroupEntity.getId())) {
			Group childGroup = new Group(childTaskGroupEntity.getId(), childTaskGroupEntity.getName(), childTaskGroupEntity.getDescription());
			childTaskGroup.add(childGroup);
		}
		TaskGroup tasksGroup = new TaskGroup(taskGroupEntity.getId(), tasks, taskGroupEntity.getName(),
				taskGroupEntity.getDescription(), parent, childTaskGroup);
		return tasksGroup;
	}

	@Override
	public AbstractEntity convertToEntity(AbstractModel model) throws ParseException {
		// TODO Auto-generated method stub
		return null;
	}

}
