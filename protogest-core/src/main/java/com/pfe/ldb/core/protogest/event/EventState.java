package com.pfe.ldb.core.protogest.event;

import java.io.Serializable;


public enum EventState implements Serializable {
	

	PENDING("Pending"), ACCEPTED("Accepted"), REFUSED("Refused");
	
	private final String state;
	private static final long serialVersionUID = 1L;


	private EventState(final String state) {
	        this.state = state;
	    }

	public String getState() {
		return this.state;
	}
}
