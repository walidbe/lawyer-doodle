package com.pfe.ldb.core.protogest.task;

import java.util.List;

import com.pfe.ldb.core.protogest.utils.AbstractModel;

public class TaskGroup extends Group {


	private List<Task> tasks;
	private Group parentGroup;
	private List<Group> childTaskGroup;
	
	
	public TaskGroup(Integer id , List<Task> tasks, String name, String description, Group parentGroup, List<Group> childTaskGroup) {
		super(id,name,description);
		this.tasks = tasks;
		this.parentGroup = parentGroup;
		this.childTaskGroup = childTaskGroup;
	}
	
	public TaskGroup(List<Task> tasks, String name, String description, Group parentGroup, List<Group> childTaskGroup) {
		super(name, description);
		this.tasks = tasks;
		this.parentGroup = parentGroup;
		this.childTaskGroup = childTaskGroup;
	}
	
	
	public List<Task> getTasks() {
		return tasks;
	}

	public Group getParentGroup() {
		return parentGroup;
	}
	public List<Group> getChildTaskGroup() {
		return childTaskGroup;
	}
}
