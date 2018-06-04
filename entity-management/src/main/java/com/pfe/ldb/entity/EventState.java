package com.pfe.ldb.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="eventState")
public class EventState extends ModelEntity {
	
	@ManyToOne
	@JoinColumn(name = "eventId")
	private EventEntity event;
	
	@ManyToOne
	@JoinColumn(name = "stateId")
	private StateNameEntity state;
	
	public EventState() {
		
	}
	
	public EventState(EventEntity event, StateNameEntity state) {
		super();
		this.event = event;
		this.state = state;
	}

	public EventEntity getEvent() {
		return event;
	}

	public void setEvent(EventEntity event) {
		this.event = event;
	}

	public StateNameEntity getState() {
		return state;
	}

	public void setState(StateNameEntity state) {
		this.state = state;
	}
	
	

	

}
