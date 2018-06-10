package com.pfe.ldb.task.iservice;

import java.util.List;

import com.pfe.ldb.core.protogest.task.Task;
import com.pfe.ldb.core.protogest.task.TaskGroup;

public interface ITaskService {

	public List<Task> loadTasks();
	public List<Task> loadTasksByGroup(Integer groupId);
	public List<TaskGroup> loadTaskGroup();

}
