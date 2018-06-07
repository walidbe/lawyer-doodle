package com.pfe.ldb.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="stateName")
public class StateNameEntity extends AbstractEntity {

	private String name;
	
	public StateNameEntity() {
		
	}
	
	public StateNameEntity(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
