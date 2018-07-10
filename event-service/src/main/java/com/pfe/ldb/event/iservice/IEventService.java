package com.pfe.ldb.event.iservice;

import java.util.List;
import com.pfe.ldb.core.protogest.event.Event;
import com.pfe.ldb.core.protogest.event.EventGroup;
import com.pfe.ldb.core.protogest.event.EventJson;


public interface IEventService {

	public List<EventJson> loadEvents();
	public List<EventGroup> loadEventsGroup();
	public Event updateEvent(Event event);
	public List<Event> updateEvents(List<Event> event);




}
