package com.pfe.ldb.calendar.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.api.services.calendar.model.Event;
import com.pfe.ldb.calendar.iservice.ICalendarService;
import com.pfe.ldb.calendar.repository.TaskRepository;
import com.pfe.ldb.core.protogest.task.Task;
import com.pfe.ldb.core.protogest.event.*;

import com.pfe.ldb.entity.TaskEntity;

public class CalendarService implements ICalendarService {


	private final static List<Event> eventList = new ArrayList<>();
	@Override
	public void saveEvents(List<Event> events) {
		eventList.addAll(events);
	}
	@Override
	public List<com.pfe.ldb.core.protogest.event.Event> generateDate(Date date) {
		List<com.pfe.ldb.core.protogest.event.Event> events = new ArrayList<>();
		Calendar c = Calendar.getInstance();
        c.setTime(date);
	//	List<TaskEntity> taskEntitys = (List<TaskEntity>) taskRepository.findAll();
		c.add(Calendar.DATE, 1);
	//	events.add(new com.pfe.ldb.core.protogest.event.Event(c.getTime(), 2));
	/*	for(Event event : eventList) {
			
			
				if(!(date.equals(event.getStart().getDate()) || date.equals(event.getEnd().getDate()))) {
			}
		}*/
		return events;
	}

}
