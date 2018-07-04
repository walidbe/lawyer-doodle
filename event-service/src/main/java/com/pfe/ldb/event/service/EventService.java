package com.pfe.ldb.event.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.ldb.core.protogest.event.Event;
import com.pfe.ldb.core.protogest.event.EventState;
import com.pfe.ldb.core.protogest.task.Task;
import com.pfe.ldb.core.protogest.task.TaskGroup;
import com.pfe.ldb.entity.EventEntity;
import com.pfe.ldb.entity.TaskEntity;
import com.pfe.ldb.entity.TaskGroupEntity;
import com.pfe.ldb.event.imapper.IMapper;
import com.pfe.ldb.event.iservice.IEventService;
import com.pfe.ldb.event.mapper.EventMapper;
import com.pfe.ldb.event.repository.EventRepository;
import com.pfe.ldb.event.repository.EventStateRepository;

@Service
public class EventService implements IEventService {


	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private EventStateRepository eventStateRepository;

	@Autowired
	private  EventMapper eventMapper;


	@Override
	public List<Event> loadEvents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event updateEvent(Event event) {
		if(event.getId() == null) {
			event.setEventState(EventState.PENDING);
		}
		else {
			event.setEventState(EventState.ACCEPTED);
		}
		EventEntity eventEntity = (EventEntity) eventMapper.convertToEntity(event);
		EventEntity updatedEvent = eventRepository.save(eventEntity);
		return (Event) eventMapper.convertToDTO(updatedEvent);
	}

	@Override
	public List<Event> updateEvents(List<Event> events) {
		List<Event> updatedEvent = new ArrayList<>();
		for(Event event : events) {
			updatedEvent.add(updateEvent(event));
		}
		return updatedEvent;
	}

}
