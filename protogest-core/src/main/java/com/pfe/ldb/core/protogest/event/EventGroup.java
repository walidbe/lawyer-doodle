package com.pfe.ldb.core.protogest.event;

import java.util.Date;

import com.pfe.ldb.core.protogest.utils.AbstractModel;

public class EventGroup extends AbstractModel {
	
	private static final long serialVersionUID = 1L;
	private String eventName;
	
	
	public EventGroup(Integer id, String eventName) {
		super(id);
		this.eventName = eventName;
	}
	
	
	public EventGroup(String eventName) {
		super();
		this.eventName = eventName;
	}
	
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

}
