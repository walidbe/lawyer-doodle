package com.pfe.ldb.event.iservice;

import java.util.List;
import java.util.Map;

import com.pfe.ldb.core.protogest.event.Event;
import com.pfe.ldb.core.protogest.event.EventGroup;
import com.pfe.ldb.core.protogest.event.EventJson;


public interface IEventService {

	public List<EventJson> loadEvents();
	public List<EventGroup> loadEventsGroup();
	public List<EventJson> loadEventsForCurrentUser(String user);
	public Event updateEvent(Event event);
	public Event updateEventForCurrentUser(Map<String,String> event);
	public Event updateEventWithSuggestionForCurrentUser(Map<String,String> event);
	public List<Event> updateEvents(List<Event> event);




}
