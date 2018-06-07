package com.pfe.ldb.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class TaskEntity extends AbstractEntity {


	private String name;
	private String description;
	@ManyToOne
	@JoinColumn(name = "taskGroupId")
	private TaskGroupEntity taskGroup;

	
	public TaskEntity() {
		
	}
	
	public TaskEntity(String name, String description, TaskGroupEntity taskGroup) {
		super();
		this.name = name;
		this.description = description;
		this.taskGroup = taskGroup;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TaskGroupEntity getTaskGroup() {
		return taskGroup;
	}

	public void setTaskGroup(TaskGroupEntity taskGroup) {
		this.taskGroup = taskGroup;
	}
}
