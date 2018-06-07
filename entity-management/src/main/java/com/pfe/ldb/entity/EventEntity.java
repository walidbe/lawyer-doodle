package com.pfe.ldb.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="event")
public class EventEntity extends AbstractEntity {


	private String name;
	private String description;
	private Date eventDate;
	
	@ManyToOne
	@JoinColumn(name = "taskId")
	private TaskEntity task;

	@ManyToOne
	@JoinColumn(name = "sourceId")
	private MemberEntity member;
	
	
	public EventEntity() {
		
	}
	
	public EventEntity(String name, String description, Date eventDate, TaskEntity task, MemberEntity member) {
		super();
		this.name = name;
		this.description = description;
		this.eventDate = eventDate;
		this.task = task;
		this.member = member;
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


	public Date getEventDate() {
		return eventDate;
	}


	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}


	public TaskEntity getTask() {
		return task;
	}


	public void setTask(TaskEntity task) {
		this.task = task;
	}


	public MemberEntity getMember() {
		return member;
	}


	public void setMember(MemberEntity member) {
		this.member = member;
	}
	
}
