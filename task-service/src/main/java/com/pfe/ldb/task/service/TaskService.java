package com.pfe.ldb.task.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.ldb.core.protogest.task.Task;
import com.pfe.ldb.core.protogest.task.TaskGroup;
import com.pfe.ldb.entity.TaskEntity;
import com.pfe.ldb.entity.TaskGroupEntity;
import com.pfe.ldb.task.imapper.IMapper;
import com.pfe.ldb.task.iservice.ITaskService;
import com.pfe.ldb.task.mapper.TaskGroupMapper;
import com.pfe.ldb.task.mapper.TaskMapper;
import com.pfe.ldb.task.repository.TaskGroupRepository;
import com.pfe.ldb.task.repository.TaskRepository;

@Service
public class TaskService implements ITaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private TaskGroupRepository taskGroupRepository;

	private final static IMapper taskMapper = new TaskMapper();
	private final static IMapper taskGroupMapper = new TaskGroupMapper();


	@Override
	public List<Task> loadTasks() {
		List<Task> tasks = new ArrayList<>();
		for (TaskEntity task : taskRepository.findAll()) {
			tasks.add((Task) taskMapper.convertToDTO(task));
		}
		return tasks;
	}

	@Override
	public List<Task> loadTasksByGroup(Integer groupId) {
		return null;
	}

	@Override
	public List<TaskGroup> loadTaskGroup() {

		List<TaskGroup> taskGroups = new ArrayList<>();
		for (TaskGroupEntity taskGroupEntity : taskGroupRepository.findAll()) {
			taskGroups.add((TaskGroup)taskGroupMapper.convertToDTO(taskGroupEntity));
		}
		return taskGroups;
	}

}
