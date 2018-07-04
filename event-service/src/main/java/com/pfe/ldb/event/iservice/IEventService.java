package com.pfe.ldb.event.iservice;

import java.util.List;
import com.pfe.ldb.core.protogest.event.Event;


public interface IEventService {

	public List<Event> loadEvents();
	public Event updateEvent(Event event);
	public List<Event> updateEvents(List<Event> event);




}
