package com.pfe.ldb.core.protogest.task;

import java.util.List;

import com.pfe.ldb.core.protogest.utils.AbstractModel;

public class TaskGroup extends AbstractModel {


	private List<Task> tasks;
	private String name;
	private TaskGroup parentGroup;
	private List<TaskGroup> childTaskGroup;
	
	
	public TaskGroup(Integer id , List<Task> tasks, String name, TaskGroup parentGroup, List<TaskGroup> childTaskGroup) {
		super(id);
		this.tasks = tasks;
		this.name = name;
		this.parentGroup = parentGroup;
		this.childTaskGroup = childTaskGroup;
	}
	
	public TaskGroup(List<Task> tasks, String name, TaskGroup parentGroup, List<TaskGroup> childTaskGroup) {
		super();
		this.tasks = tasks;
		this.name = name;
		this.parentGroup = parentGroup;
		this.childTaskGroup = childTaskGroup;
	}
	
	
	public List<Task> getTasks() {
		return tasks;
	}
	public String getName() {
		return name;
	}
	public TaskGroup getParentGroup() {
		return parentGroup;
	}
	public List<TaskGroup> getChildTaskGroup() {
		return childTaskGroup;
	}
}
