package com.pfe.ldb.event.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.ldb.core.protogest.event.Event;
import com.pfe.ldb.event.controller.path.PathURI;
import com.pfe.ldb.event.iservice.IEventService;

@RestController

public class EventController {

	@Autowired
	private IEventService eventService;

	@RequestMapping(method = RequestMethod.GET, value = PathURI.EVENT)
	public String getEvents() throws Exception {
		return "events";
	}

	@CrossOrigin(origins = "http://localhost:3001")
	@RequestMapping(method = RequestMethod.POST, value = PathURI.EVENT)
	public Event updateEvent(@RequestBody(required = true) final Event event) throws Exception {
		return eventService.updateEvent(event);
	}

	@CrossOrigin(origins = "http://localhost:3001")
	@RequestMapping(method = RequestMethod.POST, value = PathURI.EVENTS)
	public List<Event> updateEvents(@RequestBody(required = true) final Map<String, String> events) throws Exception {
		List<Event> eventss = new ArrayList<>();
		Thread.sleep(1000);
		int cnt = 1;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String eventName = events.get("eventName");
		for (String key : events.keySet()) {
			if(!key.equals("eventName")) {
				eventss.add(new Event(formatter.parse(events.get(key)), cnt++, eventName));
			}
		}
		return eventService.updateEvents(eventss);
	}

}
