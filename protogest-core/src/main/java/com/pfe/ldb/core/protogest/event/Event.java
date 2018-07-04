package com.pfe.ldb.core.protogest.event;

import java.util.Date;

import com.pfe.ldb.core.protogest.utils.AbstractModel;

public class Event extends AbstractModel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date eventDate;
	private Integer task;
	private Integer sourceId;
	private EventState eventState;
	private String eventName;
	
	public Event() {
		super();
		this.eventDate = null;
		this.task = null;
		this.sourceId = null;
		this.eventState = null;
		eventName =null;
	}
	
	public Event(Integer id, Date eventDate, Integer task, Integer sourceId, EventState eventState) {
		super(id);
		this.eventDate = eventDate;
		this.task = task;
		this.sourceId = sourceId;
		this.eventState = eventState;
	}
	
	
	public Event(Date eventDate, Integer task, Integer sourceId, EventState eventState) {
		super();
		this.eventDate = eventDate;
		this.task = task;
		this.sourceId = sourceId;
		this.eventState = eventState;
	}
	
	public Event(Date eventDate, Integer task, String eventName) {
		this.eventDate = eventDate;
		this.task = task;
		this.eventName = eventName;
	}
	
	
	
	public String getEventName() {
		return eventName;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public Integer getTask() {
		return task;
	}
	public void setTask(Integer task) {
		this.task = task;
	}
	public Integer getSourceId() {
		return sourceId;
	}
	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}
	
	public EventState getEventState() {
		return eventState;
	}
	public void setEventState(EventState eventState) {
		this.eventState = eventState;
	}
	
	
}
