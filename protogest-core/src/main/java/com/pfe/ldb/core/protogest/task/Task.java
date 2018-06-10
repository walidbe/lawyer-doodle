package com.pfe.ldb.core.protogest.task;

import com.pfe.ldb.core.protogest.utils.AbstractModel;

public class Task extends AbstractModel{


	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	
	public Task(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public Task(Integer id, String name, String description) {
		super(id);
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
}
