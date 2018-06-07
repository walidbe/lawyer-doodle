package com.pfe.ldb.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="taskGroup")
public class TaskGroupEntity extends AbstractEntity {

	private String name;
	private String description;
	@ManyToOne
	@JoinColumn(name = "parentId")
	private TaskGroupEntity parent;
	
	
	public TaskGroupEntity() {
		
	}
	
	public TaskGroupEntity(String name, String description, TaskGroupEntity parent) {
		super();
		this.name = name;
		this.description = description;
		this.parent = parent;
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

	public TaskGroupEntity getParent() {
		return parent;
	}

	public void setParent(TaskGroupEntity parent) {
		this.parent = parent;
	}
	
	

}
