package com.pfe.ldb.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.ldb.core.protogest.task.Task;
import com.pfe.ldb.core.protogest.task.TaskGroup;
import com.pfe.ldb.task.controller.path.PathURI;
import com.pfe.ldb.task.iservice.ITaskService;

@RestController

public class TaskController {

	@Autowired
	private ITaskService taskService;
	
	@RequestMapping(method = RequestMethod.GET, value = PathURI.TASKS)
    public List<Task> getTasks() throws Exception {
        List<Task> tasks = taskService.loadTasks();
        return tasks;
    }

	
    @CrossOrigin(origins = "http://localhost:3001")
	@RequestMapping(method = RequestMethod.GET, value = PathURI.TASK_GROUP)
    public List<TaskGroup> getTaskGroup() throws Exception {
        List<TaskGroup> taskGroup = taskService.loadTaskGroup();
        return taskGroup;
    }
	
	
	@RequestMapping(method = RequestMethod.GET, value = PathURI.TASK_BY_GROUPID)
    public List<Task> getTasksByGroup(@PathVariable(value = PathURI.GROUP_ID) final Integer groupId) throws Exception {
        List<Task> tasks = taskService.loadTasksByGroup(groupId);
        return tasks;
    }
	
}
