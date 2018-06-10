package com.pfe.ldb.core.protogest.task;

import com.pfe.ldb.core.protogest.utils.AbstractModel;

public class Group extends AbstractModel {


	private String name;
	private String description;
	
	public Group(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public Group(Integer id, String name, String description) {
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
